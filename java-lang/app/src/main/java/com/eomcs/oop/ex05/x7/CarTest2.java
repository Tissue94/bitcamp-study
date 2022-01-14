package com.eomcs.oop.ex05.x7;

public class CarTest2 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    test(sedan);

    System.out.println("----------------------------");

    Truck truck = new Truck();
    test(truck);

    System.out.println("----------------------------");

    Suv suv = new Suv();
    suv.active4wd(true);
    test(suv);
  }


  public static void test(Car car) {
    car.start();
    car.run();
    car.stop();
  }
}
