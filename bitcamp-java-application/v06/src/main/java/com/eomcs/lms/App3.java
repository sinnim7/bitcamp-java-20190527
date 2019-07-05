package com.eomcs.lms;

import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    
    java.io.InputStream keyboard = System.in;
    Scanner sc = new Scanner(keyboard);
    
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

}
