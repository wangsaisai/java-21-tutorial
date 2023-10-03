package com.bamboo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

/**
 * @author wangsaisai
 * @date 2023/10/3
 */
public class StructuredConcurrencyTest {

  public record Response<F, S>(F first, S second) {}

  String findUser() {
    return "user1";
  }

  Integer fetchOrder() {
    return 1;
  }

  Response<String, Integer> handle() throws ExecutionException, InterruptedException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      Supplier<String> user  = scope.fork(this::findUser);
      Supplier<Integer> order = scope.fork(this::fetchOrder);
      scope.join()            // Join both subtasks
        .throwIfFailed();  // ... and propagate errors
      // Here, both subtasks have succeeded, so compose their results
      return new Response<>(user.get(), order.get());
    }
    //...
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    StructuredConcurrencyTest test = new StructuredConcurrencyTest();
    Response<?, ?> res = test.handle();
    System.out.println(res);  // Response[first=user1, second=1]
  }


}
