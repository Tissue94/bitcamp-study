package com.eomcs.mylist;

public class MakeStar {
  public static void main(String[] args) {

    // 1) 삼각형 별 찍기 
    // 
    //    int n = 30;
    //
    //    for (int i = 0; i < n; i++) {
    //
    //      for (int j = 0; j < n; j++) {
    //
    //        if (i >= j){
    //          System.out.print("★");
    //        }
    //      }
    //      System.out.print("\n");
    //    }


    // 2) 삼각형 상하로 뒤집은 별 찍기 

    //    int n = 5;
    //
    //    for (int i = 0; i < n; i++) {
    //
    //      for (int j = i; j < n; j++) {
    //        System.out.print("★");
    //      }
    //      System.out.println("");
    //    }


    // 3) 삼각형 좌우로 뒤집은 별 찍기 
    // 
    //
    //    int n = 5;
    //
    //    for (int i = 0; i <= n; i++) {
    //
    //      for (int j = 0; j <= n; j++) {
    //
    //        if (j >= n - i) {
    //          System.out.print("★");
    //        }
    //        else {
    //          System.out.print(" ");
    //        }
    //      }
    //      System.out.println();
    //    }


    // 4) 마름모 모양으로 별 찍기 ( n 홀수만 가능 )
    int n = 5;

    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {

        if ( i <= n/2 ) { // 중앙지점(반환점) 나눔 
          if (n/2 - i -1 < j && j < n/2 + i + 1) { // 반환점 이하일 때 j 범위 나누기
            System.out.print("★");
          }
          else {
            System.out.print(" ");
          }
        }
        else {
          if (i - n/2 - 1  < j && j < n - i + n/2) { // 반환점을 초과할 때 j 범위 나누기
            System.out.print("★");
          }
          else {
            System.out.print(" ");
          }
        }
      }
      System.out.println();
    }








  }
}



