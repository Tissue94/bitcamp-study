package com.eomcs.oop.ex05.x4.app4;

// 하이브리드 자동차 만들기

// 1) 기존 코드를 상속하여 새 클래스를 만든 후 기능 덧붙이기

public class CarTest4 {

  public static void main(String[] args) {
    // 

    HybridCar car = new HybridCar();
    car.chargeBattery(100);
    //car.chargeBattery(0);
    car.start();
    car.run();
    car.stop();

  }

}
