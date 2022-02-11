// static nested class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.b;

class A {
  static class X {

  }
}

public class Exam0110 {

  public static void main(String[] args) {
    // 레퍼런스 선언
    A.X obj;

    // 인스턴스 생성
    obj = new A.X();
  }

  // ex) 안드로이드 OnClickListener 같은 클래스

}
