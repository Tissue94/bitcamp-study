package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환이 불가능한 경우, 특별한 메서드를 사용하면 가능하다. 
// 
public class Exam0951 {
  public static void main(String[] args) {

    boolean v1 = Boolean.valueOf("true"); // 문자열 ==> boolean

    char v2 = "가".charAt(0); // 문자열 ==> char

    byte b = Byte.valueOf("100");
    int i1 = Integer.valueOf("212223333"); // 문자열 ==> int
    int i2 = Integer.parseInt("2122223333"); // 문자열 ==> int
    long l = Long.valueOf("9221111222233334444");


    float v4 = Float.valueOf("3.14f"); 
    float v44 = Float.parseFloat("3.14f"); 

    System.out.println(v1);
    System.out.println(v2);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(v4);
    System.out.println(v44);
  }
}

// 자바에는 다양한 클래스가 있다. 사용하면서 확인해야 한다.
