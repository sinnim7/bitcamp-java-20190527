package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  
  static Scanner sc;

  public static void main(String[] args) {
    
    java.io.InputStream keyboard = System.in;
    sc = new Scanner(keyboard);
    
  
    int[] no = new int[100];
    String[] name = new String[100];
    String[] email = new String[100];
    String[] password = new String[100];
    String[] photo = new String[100];
    String[] phoneNum = new String[100];
    Date[] joinDate = new Date[100];

      
    int i=0;
    for(; i<no.length; i++) {
      no[i] = getIntValue("번호? ");
      name[i] = getStringValue("이름? ");
      email[i] = getStringValue("이메일? ");
      password[i] = getStringValue("암호? ");
      photo[i] = getStringValue("사진? ");
      phoneNum[i] = getPhoneNum("전화? ");
      joinDate[i] = getJoinDate("가입일? ");
      
      System.out.println("계속 입력? (Y/n) ");
      String response = sc.nextLine();
      if(response.equals("n")) {
        break;
      }
    }
        
    System.out.println();
    
    for(int i2=0; i2<=i; i2++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          no[i2], name[i2], email[i2], password[i2], photo[i2], phoneNum[i2], joinDate[i2]);
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
