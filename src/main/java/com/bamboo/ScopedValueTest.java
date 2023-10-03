package com.bamboo;

/**
 * @author wangsaisai
 * @date 2023/10/3
 */
public class ScopedValueTest {

  private static final ScopedValue<String> X = ScopedValue.newInstance();

  void foo() {
    ScopedValue.where(X, "hello").run(() -> bar());
  }

  void bar() {
    System.out.println(X.isBound());  // true
    System.out.println(X.get()); // prints hello
    ScopedValue.where(X, "goodbye").run(() -> baz());
    System.out.println(X.get()); // prints hello
  }

  void baz() {
    System.out.println(X.get()); // prints goodbye
  }

  public static void main(String[] args) {
    System.out.println(X.isBound());  // false

    ScopedValueTest test = new ScopedValueTest();
    /*
    hello
    goodbye
    hello
     */
    test.foo();

    System.out.println(X.isBound());  // false
  }

}
