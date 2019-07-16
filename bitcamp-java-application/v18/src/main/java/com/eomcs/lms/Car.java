package com.eomcs.lms;

public class Car {
  //static/class field
  //=> 클래스가 로딩될 때 Method Area에 자동 생성됨.
  //=> 클래스는 딱 한 번만 로딩되기에(중복으로 로딩되지 않음)
  //   스태틱 필드도 딱 한 번만 생성됨.
  static int count;//스태틱테스트에서 카클래스를 사용할 때 인트 카운트를 메서드 에어리어에 올림.
  //그리고 메서드에어리에에 따로 자동으로 올라감.
  //스태틱 필드나 인스턴스 필드(변수)는 자동 초기화됨.
  //이와 달리 스택에 올라가는 로컬변수는 자동 초기화 안됨.
  
  
  // instance field
  // => new 명령을 실행할 때 heap에 생성됨.
  // => new 명령을 실행하는 개수 만큼 인스턴스 필드가 생성됨.
  
  int no;
  String model;
  //스태틱이 붙지 않아 new명령을 실행해줘야 함.
  
  
  
}
