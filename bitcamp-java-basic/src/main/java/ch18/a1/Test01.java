// 인터페이스 사용 전

package ch18.a1;

public class Test01 {

  public static void main(String[] args) {

    // 객체의 기능을 사용해 보자!
    // => 각 도구의 사용법이 달라 각 도구에 맞처 기능을 사용해야 함.
    // => 그래서 각 도구에 맞는 use() 메서드를 각각 따로 준비.

    
    // 1) ToolA 객체 사용하기
    use(new ToolA());
    
    // 2) ToolB 객체 사용하기
    use(new ToolB());
    
  }

  static void use(ToolA tool) {
    // ToolA 객체를 사용하려면 m1() 메서드를 호출해야 함.
    tool.m1();
  }

  static void use(ToolB tool) {
    // ToolB 객체를 사용하려면 m2() 메서드를 호출해야 함.
    tool.m2();
  }
}







