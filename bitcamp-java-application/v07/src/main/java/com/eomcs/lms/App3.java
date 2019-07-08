package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  static Scanner sc;

  public static void main(String[] args) {
    
    java.io.InputStream keyboard = System.in;
    Scanner sc = new Scanner(keyboard);
    
    Board[] boards = new Board[100];
    
    int i=0;
    for (; i<boards.length; i++) {
      Board board = new Board();
      board.no = getIntValue("번호 ?");
      board.contents = getStingValue("내용 ?");
      board.createdDate = new Date(System.currentTimeMillis());
      board[i] = board;
    }
    
    for(int i2=0; i2<=i ; i2++) {
      Board board = boards[i2];
      System.out.printf("%s, %s ");
    }
    
    
    
    System.out.print("번호? ");
    String no = sc.nextLine();
    
    System.out.print("내용? ");
    String content = sc.nextLine();
    
    System.out.println("번호: " + no);
    System.out.println("내용: " + content);
    System.out.println("작성일: 2019-01-01");
    System.out.println("조회수: 0");

    
    
    
    
    
   /* 
    번호? 1
내용? 게시글입니다.
번호: 1
내용: 게시글입니다.
작성일: 2019-01-01
조회수: 0
    */
    
    
    
    
    
    
    
    
  }
  private static int getIntValue(String message){
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }
  
  private static String getStringValue(String message) {
    System.out.print(message);
    return (sc.nextLine());
}
  private static Date getDateValue(String message){
    while (true) {
      try {
        System.out.print(message);
        return Date.valueOf(sc.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }

}
