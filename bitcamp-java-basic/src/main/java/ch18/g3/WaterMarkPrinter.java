// 인터페이스 구현 - 새로 추가한 규칙에 따라 클래스를 구현한다. 
package ch18.g3;

public class WaterMarkPrinter implements Printer2 {
  // Printer 인터피에스에 선언된 규칙을 구현
  @Override
  public void print(String text) {
    System.out.println("WaterMarkPrinter: " + text);
  }
  
  // 신규 프로젝트에 추가한 Printer2 인터페이스의 규칙을 구현
  @Override
  public void watermark(String title) {
    System.out.println("**" + title + "**");
  }
}
