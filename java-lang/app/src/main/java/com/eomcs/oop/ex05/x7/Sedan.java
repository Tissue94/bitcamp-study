package com.eomcs.oop.ex05.x7;

public class Sedan extends Car{


  boolean auto;
  boolean sunroof;

  @Override
  public void run() {
    System.out.println("씽씽 달린다!");
  }

  public void sunroofOpen(boolean sunroof) {
    if (sunroof == true) 
      System.out.println("썬루프 열린다");
  }

}
