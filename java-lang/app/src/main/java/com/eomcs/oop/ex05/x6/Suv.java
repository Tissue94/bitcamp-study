package com.eomcs.oop.ex05.x6;

// Specialization

public class Suv extends Car{
  boolean enabled4wd;

  @Override
  public void run() {
    if (enabled4wd == true) {
      System.out.println("Suv 강력한 파워로 달린다!");
    } else {
      System.out.println("Suv 달린다!");
    }
  }

  public void active4wd(boolean enable) {
    this.enabled4wd = enable;
  }
}
