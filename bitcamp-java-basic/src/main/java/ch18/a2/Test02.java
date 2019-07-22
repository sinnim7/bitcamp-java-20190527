// 인터페이스 규칙에 따라 만든 클래스를 사용하기.
package ch18.a2;

public class Test02 {

  public static void main(String[] args) {
    // 도구 사용하기
    
    // => Spec 규칙(interface)에 따라 만든 도구(클래스)를 use() 메서드에 넘긴다.
    use(new ToolA());
    use(new ToolB());
  }
  
  static void use(Spec tool) {  //인터페이스 규칙에 따른 클래스에서 tool을 받아오는 것.
    // 파라미터 tool에 넘어오는 객체는 Spec 규칙에 따라 만든 객체일 것.
    // Spec 규칙에 따라 만든 도구를 사용할 때는
    // Spec 규칙에 따라 일관된 방식으로 사용(메서드를 호출)하면 됨.
    // tool 레퍼런스가 가리키는 인스턴스에 대해  Spec 규칙에 정의된 메서드를 호출한다.
    // 그러면 해당 인스턴스의 클래스를 찾아 그 클래스에서 구현한 메서드를 호출할 것.
    tool.m1();
  }

}







