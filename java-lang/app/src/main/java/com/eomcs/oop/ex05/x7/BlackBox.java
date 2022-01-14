package com.eomcs.oop.ex05.x7;

public class BlackBox extends Option{

  public BlackBox(Car car) {
    super(car);

  }

  @Override
  public void run() {
  }

  @Override
  public void start() {
    System.out.println("녹화 시작");
    super.start();
  }


  @Override
  public void stop() {
    System.out.println("녹화 종료");
    super.stop();
  }
}
