// 프로퍼티 값 변환기 - 프로퍼티 에디터를 사용하여 String을 java.util.Date 객체로 바꾸기
package ch29.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/g/application-context-03.xml");

    System.out.println("---------------------------------------");

    System.out.println(iocContainer.getBean("c1"));

    
    //setCustomEditors(Map<Class<?>,Class<? extends PropertyEditor>> customEditors);
    /*
    Map<String, Car> map1 = new HashMap<>();
    map1.put("str2", new Car());
*/
/*

    Map<<Class<?>, Class<? extends Car>> map2 = new HashMap<>();
    //=> "key(?:아무거나)도 value도 Car 클래스 정보만 받을거야"
    
    //map2.put("str1", Car.class);
    //map2.put("str2", BlackBox.class);
    //map2.put("str2", Tico.class);
    map2.put(String.class, Car.class);
    map2.put(File.class, Car.class);
    
    */
    /*
    Car.ok = 100;
    Car.no = "okok";
    Car.cls = map1.getClass();
      */  
    
  }
  /*
  static class Tico extends Car {
    
  }
*/
  /*
  static class Car {
    static Class cls;  // 일반적으론 변수명으로 class 쓸 수 없음.
    static int ok;
    static String no;
  }
  */


}






