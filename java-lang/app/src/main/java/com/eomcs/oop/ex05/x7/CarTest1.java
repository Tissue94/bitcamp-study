package com.eomcs.oop.ex05.x7;

public class CarTest1 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    test(sedan);

    System.out.println("----------------------------");

    Truck truck = new Truck();
    test(truck);

  }


  public static void test(Car car) {
    car.start();
    car.run();
    car.stop();
  }
}
