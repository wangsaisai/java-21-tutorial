package com.bamboo;

/**
 * @author wangsaisai
 * @date 2023/10/2
 */
public class SwitchTest {

  static String formatterPatternSwitch(Object obj) {
    return switch (obj) {
      case Integer i -> String.format("int %d", i);
      case Long l -> String.format("long %d", l);
      case Double d -> String.format("double %f", d);
      case String s -> String.format("String %s", s);
      default -> String.format("obj %s", obj);
    };
  }

  public static void main(String[] args) {
//    int 1
//    long 1696229841520
//    double 0.010000
//    String hello
//    obj java.lang.Object@4e50df2e
    System.out.println(formatterPatternSwitch(1));
    System.out.println(formatterPatternSwitch(System.currentTimeMillis()));
    System.out.println(formatterPatternSwitch(0.01));
    System.out.println(formatterPatternSwitch("hello"));
    System.out.println(formatterPatternSwitch(new Object()));
  }

}
