package com.eomcs.oop.ex05.x7;

public abstract class Option extends Car{

  Car car;

  public Option(Car car) {
    this.car = car;
  }

  @Override
  public void start() {
    // TODO Auto-generated method stub
    car.start();
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    car.stop();
  }

}
