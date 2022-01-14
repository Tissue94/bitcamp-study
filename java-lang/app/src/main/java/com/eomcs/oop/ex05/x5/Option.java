package com.eomcs.oop.ex05.x5;

public abstract class Option extends Car{

  Car car;

  public Option(Car car) {
    this.car = car;
  }


}

// 데코레이터 : 주 객체에게 붙이는 선택기능
