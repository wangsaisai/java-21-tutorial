package com.bamboo.sealed;

public final class Truck extends Vehicle {
  private final String name;
  private final int speed;

  public Truck(String name, int speed) {
    this.name = name;
    this.speed = speed;
  }

  public String getName() {
    return name;
  }

  public int getSpeed() {
    return speed;
  }
}
