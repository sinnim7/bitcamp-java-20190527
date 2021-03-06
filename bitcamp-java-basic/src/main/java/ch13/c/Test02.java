// 상속과 메서드 호출
package ch13.c;

public class Test02 {

  public static void main(String[] args) {
    D obj = new D();
    
    obj.m4();  // obj 레퍼런스의 클래스에서 m4()를 찾아 호출.
    obj.m3();  // obj 레퍼런스의 클래스(D)에서 m3()를 찾아보고 없다면 수퍼 클래서에서 찾음. 
    obj.m2();  // 만일 D의 수퍼 클래스에서도 못찾는다면 그 위의 클래스에서 찾아봄.
    obj.m1();  // 그 위 클래스에서도 없다면 더 위에 클래스에서 찾아봄.
    //obj.m0();  // 더 위에 있는 클래스에서도 찾을 수 없다면 컴파일 오류다!
    
    // 즉 메서드를 호출할 땐 클래스 상속 관계에 따라 
    // 레퍼런스의 클래스에서 시작해 상위 클래스로 찾아감.
    // 그래서 클래스를 사용하려면 그 크래스가 상속받는 상위 클래스들이 모두 있어야 함.
  }

}
