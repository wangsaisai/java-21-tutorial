package com.bamboo;

import java.time.DayOfWeek;

/**
 * @author wangsaisai
 * @date 2023/10/2
 */
public class UnnamedTest {

  public static void exceptionTest() {
    try {
    } catch (Exception _) {
      System.out.println("exceptionTest");
    }
  }

  public static void exceptionTest2() {
    try {
      throw new RuntimeException();
    } catch (Exception e) {
      System.out.println("exceptionTest2");
    }
  }

  /*
  todo 不调用该函数，只在类中定义。仍然报错：(不抛异常，或不使用匿名字段，就不会报错)
  错误: 加载主类 com.bamboo.UnnamedTest 时出现 LinkageError
	java.lang.ClassFormatError: Illegal field name "" in class com/bamboo/UnnamedTest
   */
//  void exceptionTest3() {
//    try {
//      throw new RuntimeException();
//    } catch (Exception _) {
//      System.out.println("exceptionTest3");
//    }
//  }

  public static void instanceTest() {
    Object obj = "hello";
    if (obj instanceof String _) {
      System.out.println("obj is a non-null string");
    }
  }

  public static void switchTest() {
    DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
    switch (dayOfWeek) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> System.out.println("Weekday");
      case FRIDAY -> System.out.println("Friday");
      case SATURDAY, SUNDAY -> System.out.println("Weekend");
      case null, default -> System.out.println("null");
    }
  }

  public static void main(String[] args) {
    exceptionTest();
    exceptionTest2();
//    exceptionTest3();
    instanceTest();
    switchTest();
  }

}
