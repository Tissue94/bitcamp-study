package com.eomcs.oop.ex05.x6;

public class Sedan extends Car{

  boolean auto;
  boolean opendSunroof;

  @Override
  public void run() {
    System.out.println("씽씽 달린다!");
  }

  public void openSunroof() {
    System.out.println("openSunroof !");
  }

  public void closeSunroof() {
    System.out.println("closeSunroof !");
  }
}
