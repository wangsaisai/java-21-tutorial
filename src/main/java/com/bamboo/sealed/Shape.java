package com.bamboo.sealed;

/**
 * @author wangsaisai
 * @date 2023/10/6
 */
public abstract sealed class Shape {

  public static final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
      this.radius = radius;
    }

    public double getArea() {
      return Math.PI * radius * radius;
    }
  }

  public static final class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
      this.width = width;
      this.height = height;
    }

    public double getArea() {
      return width * height;
    }
  }

}




