package com.eomcs.oop.ex05.x4.app3;

// 캠핑카 만들기

// 1) 기존 코드를 상속하여 새 클래스를 만든 후 기능 덧붙이기

public class CarTest3 {

  public static void main(String[] args) {
    // CampingTrailer 클래스를 만든다
    // Car 클래스를 상속 받아 TrailerCar 클래스를 만든 후 트레일러를 설정하는 변수와 메서드를 추가한다. 
    // trailer 변수, setTrailer() 추가
    // run() 메서드 오버라이딩

    CampingTrailer trailer = new CampingTrailer();

    TrailerCar car = new TrailerCar();
    car.setTrailer(trailer);
    car.start();
    car.run();
    car.stop();

  }

}
