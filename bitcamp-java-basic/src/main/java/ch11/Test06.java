// String 클래스 사용법 - 기타 메서드
package ch11;

import java.sql.Date;

public class Test06 {
  public static void main(String[] args) {
    
    // String 클래스의 스태틱 메서드 활용
    String s1 = String.format("%s님의 나이는 %d입니다.", "홍길동", 20);
    System.out.println(s1);
    
    
    
    String a1 = String.format("%s은 %d월 %d일 입니다.", "오늘", 7, 12);
    System.out.println(a1);
    
    // 기본 데이터 타입의 값을 문자열로 만들기
    String s2 = String.valueOf(true); // true => "true"
    String s3 = String.valueOf(100); // 100 => "100"
    String s4 = String.valueOf(100L); // 100L => "100"
    String s5 = String.valueOf(3.14f); // 3.14f => "3.14"
    String s6 = String.valueOf(3.14); // 3.14 => "3.14"
    String s7 = String.valueOf('가'); // '가' => "가"
    
    
    String a2 = String.valueOf(false);
    String a3 = String.valueOf(200);
    String a4 = String.valueOf(300l);
    String a5 = String.valueOf(4.15f);
    String a6 = String.valueOf(2.28);
    String a7 = String.valueOf('나');
    
    
    System.out.println(a2);
    System.out.println(a3);
    System.out.println(a4);
    System.out.println(a5);
    System.out.println(a6);
    System.out.println(a7);
    
    
    
    /*
    
    System.out.println(s2);
    System.out.println(s3);
    System.out.println(s4);
    System.out.println(s5);
    System.out.println(s6);
    System.out.println(s7);
    */
    
  }
}
















