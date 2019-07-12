// Wrapper 클래스 : 사용 후
package ch11;

import java.util.Date;

public class Test09_3 {
  public static void main(String[] args) {
    // => primitive 값을 포함하여 모든 값을 쉽게 주고 받기 위함이다.
    // primitive Type의 값을 전달할 때는 Test09_2의 경우와 같이
    // 각 타입의 값을 받는 메서드를 여러 개 만들어야 하지만
    // Wrapper 클래스의 인스턴스를 사용하면 타입의 종류와 상관없이
    // 파라미터로 값을 받는 메서드를 한 개만 만들어도 된다.


    // Wrapper 클래스를 사용하지 않으면 다음과 같이 각 타입의 값을 처리할 메서드를
    // 여러 개 만들어야 한다.
    Integer obj1 = Integer.valueOf(100);
    Float obj2 = Float.valueOf(3.14f);
    Character obj3 = Character.valueOf('A');
    Boolean obj4 = Boolean.valueOf(true);
    
    printInt(obj1);
    printInt(obj2);
    printInt(obj3);
    printInt(obj4);
    
    

  }

  static void printInt(Object obj) {
    System.out.println("값 => " + obj.toString());
  }



}


