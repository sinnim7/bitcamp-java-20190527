package ch18.g5;

import ch18.g2.Printer;

// 신규 프로젝트에선 워터마킹 기능을 갖는 프린터가 필요.
// => 기존 인터페이스인 Printer에 워터마킹 기능을 추가하게 되면
//    기존에 구현한 모든 클래스들도 새 규칙을 구현해야 하는 문제가 발생.
//    만약 구현하지 않으면 컴파일 오류가 발생할 것.
// => 이를 해결하는 전통적인 방식에선
//    다음과 같이 새 기능을 추가한 인터페이스를 새로 만드는 것.

public interface Printer2 extends Printer {
  
  // 기존 프린터의 규칙은 그대로 사용해야 해서
  // 상속받는다.
  // 그리고 다음과 같이 새 규칙을 추가.
  void watermark(String title);
}
