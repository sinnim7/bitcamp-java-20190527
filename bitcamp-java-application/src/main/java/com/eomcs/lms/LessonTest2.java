package com.eomcs.lms;

import java.sql.Date;

public class LessonTest2 {
  public static void main(String[] args) {
    
    //레퍼런스 배열을 가리키는 레퍼런스 만들기
    Lesson[] arr; //arr [배열 주소]
    
    //Lesson 레퍼런스 배열 만들기
    //==>Lesson 인스턴스의 주소를 저장할 레퍼런스를 3개 만든다.
    //==>Lesson 인스턴스를 3개 만드는 게 아님.!!!!
    arr = new Lesson[3]; // [배열주소] ====> [0레퍼런스] [1레퍼런스] [2레퍼런스]
    
    //arr가 가리키는 배열에서 0번 레퍼런스 변수에 Lesson 인스턴스 주소를 저장하지 않고 사용하면?
    //=> arr가 가리키는 배열에서 0번 변수엔 아무런 주소가 들어있지 않다.
    // => 레퍼런스 배열의 각 변수에 인스턴스 주소를 넣지 않고 사용하면 NullPointerException 발생.
    //arr[0].no = 100; //=>NullPointerException 오류
    
    arr[0] = new Lesson(); //주소를 저장할 각각의 레퍼런스를 만들어 인스턴스 주소를 만듦.
    arr[1] = new Lesson();
    arr[2] = new Lesson();
    
    arr[0].no = 100; 
    arr[0].title = "자바";
    
    arr[1].no = 200;    
    arr[1].title = "웹";
    
    int[] arr2 = new int[3];//이건 인트 변수 3개를 만들라는 것.
    arr2[0] = 100;
    
  }
  
}
