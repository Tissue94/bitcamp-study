//변수 : 스프링 부트의 자동 형변환

package com.eomcs.study.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam3") // 클래스 이름이 같은 경우(패키지가 다를지라도) 충돌 방지 어떤 클래스를 실행할 지 지정
@RequestMapping("/lang/variable/exam3")
public class Exam3 {



  //스프링 부트는 클라이언트가 보낸 값을 파라미터의 타입에 맞춰 자동 형변환을 수행한다.
  //웹 브라우저가 보내는 값은 무조건 문자열이다

  @GetMapping("/test1")
  public String test1(byte value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test2")
  public String test2(short value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test3")
  public String test3(int value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test4")
  public String test4(long value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test5")
  public String test5(float value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test6")
  public String test6(double value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test7")
  public String test7(boolean value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test8")
  public String test8(char value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }

  @GetMapping("/test9")
  public String test9(java.sql.Date value) {
    //문자열을 표현하는 방법
    return " ==> " + value;
  }



}
