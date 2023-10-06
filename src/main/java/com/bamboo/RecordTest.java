package com.bamboo;

/**
 * @author wangsaisai
 * @date 2023/10/2
 */
public class RecordTest {

  record Point(int x, int y) {}

  static void printSum(Object obj) {
    if (obj instanceof Point(int x, int y)) {
      System.out.println(x + y);
    }
  }

  public static void main(String[] args) {
    Point p = new Point(1, 2);
    System.out.println(p.x);  // 1
    System.out.println(p.x());  // 1
    printSum(new Point(1, 2));  // 3
  }

}
