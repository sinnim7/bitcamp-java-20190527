package ch18.g4;

import ch18.g2.Printer;
import ch18.g3.Printer2;

// 어댑터 패턴 : 기존 작성한 클래스를 새 규격에 맞춰 재활용할 수 있게 만드는 설계 기법.

public class Printer2Adapter implements Printer2{
  
  // 이 클래스는 중간에서 Printer2에 꼽을 수 있게 중계하는
  // 역할만 해서 이 클래스가 직접 printer 기능을 구현해선 안 됨.
  // 대신 Printer 기능은 기존 클래스에 맡겨야 함.
  Printer originalPrinter;
  
  public Printer2Adapter(Printer originalPrinter) {
    this.originalPrinter = originalPrinter;
  }

  @Override
  public void print(String text) {
    // 아답터는 Printer2의 규격을 따르긴 하지만
    // 직접 Printer 역할을 하는 게 아니라서
    // 아답터에게 Print()라는 명령을 내리면
    // 생성자에서 받은 기존 프린터 객체를 실행시킴.
    originalPrinter.print(text);
  }
  
  @Override
  public void watermark(String title) {
    // 단 Printer2에 추가된 워터마킹 기능은 아답터에서 실행함.
    System.out.println(title);
  }
  
}
