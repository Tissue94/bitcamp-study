package com.eomcs.util;

import java.util.Scanner;

public class Prompt {
  static Scanner keyscan =  new Scanner(System.in);

  public static String promptString(String titleFormat, Object... args) {
    System.out.println(String.format(titleFormat, args));
    return keyscan.nextLine();
  }
  // 리턴타입만 다른것은 메서드를 구분할 수 없다.
  public static int promptInt(String titleFormat, Object... args) {
    return Integer.parseInt(promptString(titleFormat, args));
  }
}
