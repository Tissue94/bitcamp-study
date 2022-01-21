
package com.eomcs.app1;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("> ");
      String input = keyScan.nextLine();

      if (input.equals("quit") || input.equals("exit")) {
        break;
      } else if (input.length() == 0) {
        continue;
      } else if (input.equals("help")) {
        System.out.println("add   [값1] [값2]   더하기 계산을 수행한다.");
        System.out.println("minus [값1] [값2]   빼기 계산을 수행한다.");
        System.out.println("help                도움말을 출력한다.");
      } else {
        String[] values = input.split(" ");
        if (values[0].equals("add")) {
          if (values.length != 3) {
            System.out.println("명령어 형식이 옳지 않습니다.");
          } else {
            int v1 = Integer.parseInt(values[1]);
            int v2 = Integer.parseInt(values[2]);
            System.out.printf("%d + %d = %d\n", v1 , v2, (v1+v2));
          } 
        } else if (values[0].equals("minus")) {
          if (values.length != 3) {
            System.out.println("명령어 형식이 옳지 않습니다.");
          } else {
            int v1 = Integer.parseInt(values[1]);
            int v2 = Integer.parseInt(values[2]);
            System.out.printf("%d - %d = %d\n", v1 , v2, (v1-v2));
          } 
        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      }
    }

    keyScan.close();
    /*
    java.io.InputStream keyboard = System.in;

    Scanner sc = new Scanner(keyboard);

    System.out.print("> ");

    String str = sc.nextLine(); 


    if (str.equals("help")) {
      System.out.println("add   [값1] [값2]   더하기 계산을 수행한다.");
      System.out.println("minus [값1] [값2]   빼기 계산을 수행한다.");
      System.out.println("help  도움말을 출력한다.");
    } else if (str.equals("add")) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int v1 = a;
      if (b == 0 || b == Integer.parseInt("")) {
        System.out.println("명령어 형식이 옳지 않습니다.");
      } else {
        int v2 = b;
        System.out.printf("%d + %d = %d\n", v1 , v2, (v1+v2));
      }
    } else if (str.equals("minus")) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int m1 = a;
      if (b == 0) {
        System.out.println("명령어 형식이 옳지 않습니다.");
      } else {
        int m2 = b;
        System.out.printf("%d - %d = %d\n", m1 , m2, (m1-m2));
      }
    } else {
      System.out.println("지원하지 않는 연산자입니다.");
    }

    sc.close();
     */
  }
}

