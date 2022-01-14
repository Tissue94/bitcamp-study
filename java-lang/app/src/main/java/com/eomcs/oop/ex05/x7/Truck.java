package com.eomcs.oop.ex05.x7;

public class Truck extends Car{

  int weight;

  public void launch() {
    System.out.println("트럭 시동 건다");
  }

  public void running() {
    System.out.println("트럭 덜컹덜컹 달린다");
  }

  public void stopping() {
    System.out.println("트럭 시동 끈다");
  }

  @Override
  public void run() {
    this.running();

  }

  @Override
  public void start() {

    this.launch();
  }

  @Override
  public void stop() {

    this.stopping();
  }

  public void dump() {
    System.out.println("싣는다!");
  }
}
