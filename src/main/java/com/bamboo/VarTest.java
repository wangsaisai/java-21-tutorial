package com.bamboo;

import java.util.ArrayList;

public class VarTest {

  public static void main(String[] args) {

    // 推断为ArrayList<String>类型
    var list = new ArrayList<String>();
    list.add("Hello");
    list.add("World");
    // 在for循环中使用var关键字进行类型推断
    for (var item : list) {
      System.out.println(item);
    }

    // 推断为String类型
    var str = "Hello, World!";

    // 推断为int类型
    var num = 42;

    // 推断为double类型
    var pi = 3.14159;

    // 推断为自定义类型Person
    var person = new Person("John", 30);
    var name = person.name();
    var age = person.age();
    System.out.println(name + age); // John30
  }
}

record Person (String name, int age) {}