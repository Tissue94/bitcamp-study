package com.eomcs.oop.ex05.x7;

public abstract class SnowChain extends Option{

  public SnowChain(Car car) {
    super(car);
  }

  @Override
  public void run() {
    System.out.println("눈 마찰력을 증가시킨다.");
    car.run();
  }
}
