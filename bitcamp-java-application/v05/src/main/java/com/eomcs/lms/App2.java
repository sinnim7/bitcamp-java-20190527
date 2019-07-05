package com.eomcs.lms;

import java.util.Scanner;

public class App2 {
  
  static Scanner sc;

  public static void main(String[] args) {
    
    java.io.InputStream keyboard = System.in;
    sc = new Scanner(keyboard);
    
    
    int no = getIntValue("번호? ");
    
    String name = getStringValue("이름? ");
    String email = getStringValue("이메일? ");
    String password = getStringValue("암호? ");
    String photo = getStringValue("사진? ");
    
    String phoneNum = getPhoneNum("전화? ");
    
    java.sql.Date joinDate = getJoinDate("가입일? ");
    
        
    System.out.println();
    
    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("암호: " + password);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + phoneNum);
    System.out.println("가입일: " + joinDate);
    
   
  }
  
  private static int getIntValue(String message) {
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
        return sc.nextLine();
    }
    
  
  private static String getPhoneNum(String message) {
        System.out.println(message);
        return sc.nextLine();
  }
  
  private static java.sql.Date getJoinDate(String message) {
    while (true) {
      try {
        System.out.println(message);
        return java.sql.Date.valueOf(sc.nextLine());
        
      }catch (IllegalArgumentException e) {
        System.out.println("2019-01-01 형식으로 입력해주세요.");
      }
    }
  }

}
