package com.bamboo.sealed;

public abstract sealed class Vehicle permits Car, Truck {
  public abstract String getName();

  public abstract int getSpeed();

  public static Vehicle create(String name, int speed) {
    if (speed > 50) {
      return new Car(name, speed);
    } else {
      return new Truck(name, speed);
    }
  }
}

