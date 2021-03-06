//리터럴 : 부동소수점 리터럴과 값의 범위
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam4")
public class Exam4 {

  @GetMapping("/test1")
  public String test1() {
    float value = 987.6543f; // 4바이트 메모리 사용, 유효자리수를 넘어가는 값은 짤린다.
    return "부동소수점: " + value; 
  }

  @GetMapping("/test2")
  public String test2() {
    double value = 987.654321; // 8바이트 메모리 사용
    return "부동소수점: " + value; 
  }

  @GetMapping("/test3")
  public String test3() {
    double value = 987.654321f; // 8바이트 메모리 사용
    return "부동소수점: " + value; 
  }

  @GetMapping("/test4")
  public String test4() {
    double value = 987654321.123456789; // 8바이트 메모리 사용
    return "부동소수점: " + value; 
  }
}

