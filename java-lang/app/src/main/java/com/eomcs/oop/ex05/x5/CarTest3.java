package com.eomcs.oop.ex05.x5;

public class CarTest3 {

  public static void main(String[] args) {

    ElectricEngine electricOption = new ElectricEngine(new Sedan());

    electricOption.chargeBattery(100);

    CampingTrailer ap = new CampingTrailer();

    Trailer trailer = new Trailer(electricOption);
    trailer.start();
    trailer.setTrailer(ap);
    trailer.run();
    trailer.stop();

    System.out.println("----------------------------");

    ElectricEngine electricOption2 = new ElectricEngine(new Truck());
    electricOption2.chargeBattery(300);
    electricOption2.start();
    electricOption2.run();
    electricOption2.stop();
  }

}
