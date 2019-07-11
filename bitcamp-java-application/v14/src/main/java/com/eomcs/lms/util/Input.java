package com.eomcs.lms.util;

import java.sql.Date;
import java.util.Scanner;

public class Input {  //키보드는 따로 관리할 이유가 없어 스태틱으로 놔둠.
  //인스턴스 필드(변수)가 없고 쓰지도 않으면 메소드도 걍 스태틱으로.
  
  
  
  
  //Input에 연결된 Scanner 객체를 각 Input마다 개별적으로 관리하기 위해 인스턴스 필드로 선언.
  private Scanner keyScan; // 분리된 멀티탭 생각해보면될듯.
  //public static Scanner keyScan = new Scanner(Systme.in); 특정 스캐너로 고정하지 않은 이윤 다양한 곳에서 입력받게 하기 위해
  
 
  public Input(Scanner keyScan) { //필수값을 파라미터에 넣게끔. App에선 인풋 인스턴스를 만들때 키스캔을 반드시 넣도록 함.
  //Input 클래스에 있는 메서드를 사용하는 데 필요한 keyScan 변수를 준비시킨다. 
  // 단 인스턴스를 생성할 때 반드시 Scanner 객체를 넘기도록 강제하기 위해
  // 생성자에 파라미터 변수를 선언.
    
    
    this.keyScan = keyScan;
  }
  
  
  // 기존의 스태틱 메서드를 인스턴스 메서드로 전환한 이유?
  // => 각 Input 객체마다 Scanner를 구분해 다루려고.
  public int getIntValue(String message) { //파라미터를 다루는 메소드는 스태틱으로.ex)Math 클래스
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }

  public Date getDateValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("2019-07-05 형식으로 입력하세요.");
      }
    }
  }

  public String getStringValue(String message) {
    System.out.print(message);
    return (keyScan.nextLine());
  }
  
  
}
