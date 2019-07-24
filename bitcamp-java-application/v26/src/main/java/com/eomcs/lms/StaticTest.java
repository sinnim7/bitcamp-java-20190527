package com.eomcs.lms;

public class StaticTest {

  public static void main(String[] args) {
    
  //스태틱 필드 사용하기
    //=> 클래스 이름으로 사용하면 됨.
    

    System.out.println(Car.count); //=> 카 클래스 작동.
    
    
    //인슨턴스 필드 사용하기
    Car c1;
    c1 = new Car(); // new를 통해서 heap에 no와 model이 올라가고 주소가 생성됨.
    c1.no = 1;
    c1.model = "티코";
    c1.count++; // 스태틱 필드는 보통 클래스 이름으로 사용.
                //그러나 클래스 이름 대신 래퍼런스를 통해 스태틱 필드를 사용할 수 있음. 단, 비추!
                //개발자가 인슨턴스 필드라고 착각할 수 있음. 따라서 이런 식으로 사용하지 말 것.
                //car클에서 찾아 1증가
    Car c2 = new Car(); // new를 통해서 heap에 새로 no와 모델을 생성.
    c2.no = 2;
    c2.model = "소나타";
    c2.count++; //car클에서 찾아 1증가
    
    System.out.printf("%d, %s\n", c1.no, c1.model);
    System.out.printf("%d, %s\n", c2.no, c2.model);
    
    System.out.println(Car.count);
    
  }
  
  
 
  
  
  
}
