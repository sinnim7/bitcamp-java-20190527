// JVM 아규먼트 응용 II
package ch06;

import java.util.Set;

public class Test18 {
  public static void main(String[] args) {
    // JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력하라!
    //
    
    // JVM의 전체 프로퍼티 목록 가져오기
    java.util.Properties props = System.getProperties();
    
    java.util.Set keySet = props.keySet();//이름이 들어있는 집합(Properties)의 인스턴스 주소를 리턴.
                                          //"Properties 객체를 리턴한다." 이렇게도 말함.
    
    for (Object key : keySet) { //셋에서 값을 꺼낼 때 스트링으로 받지 못함. 그래서 오브젝트로 .
      String value = System.getProperty((String)key); // 스트링으로 값을 꺼내려면 앞에 형변환을 해줘야함.
      System.out.printf("%s = %s\n", key, value);
    }
  }
  //C:\Users\bit\git\bitcamp-java-20190527\bitcamp-java-basic>java -classpath ./bin/main ch06.Test18
}















