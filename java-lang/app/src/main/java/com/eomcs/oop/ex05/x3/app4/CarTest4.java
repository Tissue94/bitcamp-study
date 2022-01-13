package com.eomcs.oop.ex05.x3.app4;

// 하이브리드 자동차 만들기

// 1) 기존 코드에 기능 덧붙이기

public class CarTest4 {

  public static void main(String[] args) {
    // Engine 클래스에 하이브리드 기능 추가하기 

    Engine car = new Engine();
    car.chargeBattery(100);
    car.start();
    car.run();
    car.stop();

  }

}