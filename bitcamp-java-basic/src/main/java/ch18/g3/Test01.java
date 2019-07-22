package ch18.g3;

import ch18.g2.FilmPrinter;
import ch18.g2.PaperPrinter;

public class Test01 {

  public static void main(String[] args) {

    //신규 프로젝트에선 워터마킹 기능이 있는 프린터 사용.
    
    //프린터 준비
    WaterMarkPrinter p1 = new WaterMarkPrinter();
    
    //프린터를 사용해 출력
    display(p1, "안녕하세요!", "bitcamp bitcamp bitcamp bitcamp bitcamp");
    
    //기존 프린터 준비!
    PaperPrinter p2 = new PaperPrinter();
    FilmPrinter p3 = new FilmPrinter();
    
    // 안타깝게도 기존 프린터는 새 프린터 규격에 맞지 않아
    // 출력하는 데 사용할 수 없음.
    // => 컴파일 오류!
    //display(p2, "안녕하세요!", "bitcamp bitcamp bitcamp bitcamp bitcamp");
    //display(p3, "안녕하세요!", "bitcamp bitcamp bitcamp bitcamp bitcamp");
  }

  private static void display(Printer2 printer, String text, String watermarkText) {
    
    printer.watermark(watermarkText);
    printer.print(text);
    printer.watermark(watermarkText);
  }
  
}
