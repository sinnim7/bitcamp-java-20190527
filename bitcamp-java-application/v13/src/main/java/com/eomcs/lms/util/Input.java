package com.eomcs.lms.util;

import java.sql.Date;
import java.util.Scanner;

public class Input {  //키보드는 따로 관리할 이유가 없어 스태틱으로 놔둠.
  //인스턴스 필드(변수)가 없고 쓰지도 않으면 메소드도 걍 스태틱으로.
  public static Scanner keyScan;
  
  public static int getIntValue(String message) { //파라미터를 다루는 메소드는 스태틱으로.ex)Math 클래스
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }

  public static Date getDateValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }

  public static String getStringValue(String message) {
    System.out.print(message);
    return (keyScan.nextLine());
  }
  
  
}
