package com.bamboo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author wangsaisai
 * @date 2023/10/2
 */
public class VirtualThreadTest {

  public static void startVirtualThreadTest() throws InterruptedException {
    // 传入Runnable实例并立刻运行:
    Thread vt = Thread.startVirtualThread(() -> {
      System.out.println("Thread.startVirtualThread() ... start");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Thread.startVirtualThread() ... end");
    });

    vt.join();
  }

  public static void createStartVirtualThreadTest() throws InterruptedException {
    // 创建VirtualThread:
    Thread vt = Thread.ofVirtual().unstarted(() -> {
      System.out.println("Thread.ofVirtual().unstarted ... start");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Thread.ofVirtual().unstarted ... start end");
    });

    vt.start();
    vt.join();
  }

  public static void threadFactoryNewThreadTest() throws InterruptedException {
    // 创建ThreadFactory:
    ThreadFactory tf = Thread.ofVirtual().factory();

    // 创建VirtualThread:
    Thread vt = tf.newThread(() -> {
      System.out.println("ThreadFactory.newThread ... start");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("ThreadFactory.newThread ... end");
    });

    // 运行:
    // 直接调用start()实际上是由ForkJoinPool的线程来调度的
    vt.start();
    vt.join();
  }

  public static void threadPoolNewThreadTest() {
    long start = System.currentTimeMillis();

    // 创建调度器:
    ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    // 创建大量虚拟线程并调度:
    ThreadFactory tf = Thread.ofVirtual().factory();
    for (int i = 0; i < 100000; i++) {
      int finalI = i;
      // 无输出
      Thread vt = tf.newThread(() -> System.out.println(finalI));
      executor.submit(vt);
      // 也可以直接传入Runnable或Callable:
      executor.submit(() -> {
        // 有输出
        System.out.println("hello " + finalI);
        return true;
      });
    }
    executor.close();

    long end = System.currentTimeMillis();
    // All virtual threads end at 2218 ms.
    System.out.printf("All virtual threads end at %s ms.\n", end - start);
  }

  public static void main(String[] args) throws InterruptedException {
    startVirtualThreadTest();
    createStartVirtualThreadTest();
    threadFactoryNewThreadTest();
    threadPoolNewThreadTest();
  }


}
