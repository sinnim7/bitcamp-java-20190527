package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  
  static Scanner sc;

  public static void main(String[] args) {
    
    java.io.InputStream keyboard = System.in;
    sc = new Scanner(keyboard);
    
    Member[] member = new Member();
    
  
    Member[] no = new int[100];
    String[] name = new String[100];
    String[] email = new String[100];
    String[] password = new String[100];
    String[] photo = new String[100];
    String[] tel = new String[100];
    Date[] registeredDate = new Date[100];

      
    int i=0;
    for(; i<no.length; i++) {
      Member.no = getIntValue("번호? ");
      Member.name = getStringValue("이름? ");
      Member.email = getStringValue("이메일? ");
      Member.password = getStringValue("암호? ");
      Member.photo = getStringValue("사진? ");
      Member.tel = gettel("전화? ");
      Member.registeredDate = getregisteredDate("가입일? ");
      
      System.out.println("계속 입력? (Y/n) ");
      String response = sc.nextLine();
      if(response.equals("n")) {
        break;
      }
    }
        
    System.out.println();
    
    for(int i2=0; i2<=i; i2++) {
      Member member = members[i2];
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          member.no, member.name, member.email, member.password, 
          member.photo, member.tel, member.registeredDate);
    }
    
    
    
    
    
    
    
   
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
    
  
  private static String gettel(String message) {
        System.out.println(message);
        return sc.nextLine();
  }
  
  private static java.sql.Date getregisteredDate(String message) {
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
