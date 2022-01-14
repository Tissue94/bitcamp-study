package com.eomcs.oop.ex05.x6;

public class CarTest3 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    SnowChain car = new SnowChain(sedan);
    testCar(car);

    System.out.println("-------------------");

    BlackBox car1 = new BlackBox(new Truck());
    testCar(car1);

    System.out.println("-------------------");

    BlackBox car2 = new BlackBox(new SnowChain(new Suv()));
    testCar(car2);
  }

  static void testCar(Car car) {
    car.start();
    car.run();
    car.stop();
  }

}
