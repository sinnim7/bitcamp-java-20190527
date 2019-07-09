// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행함.

package com.eomcs.lms;


import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.lms.util.Input;

// 임포트 라인수가 늘어나도 컴파일러에게 알려주는 것이기에 문제 없음.

public class App {

  static Scanner keyScan;

  
  public static void main(String[] args) {

    keyScan = new Scanner(System.in);
    Input.keyScan = keyScan;
    
    
    LessonHandler lessonHandler = new LessonHandler();
    LessonHandler.keyScan = keyScan;
    
    
    MemberHandler memberHandler = new MemberHandler();  //인스턴스로 만든 건 한개 만들더라도 나중에 여러개를 만들때를 대비.(스태틱 아님)
    MemberHandler.keyScan = keyScan;                   //인스턴스 필드를 쓰는 이유.스태틱은 힙에 메모리가 한개밖에 만들지못함.
                                                       //인스턴스가 하나라면 클래스 이름과 같게(소문자로 시작)
    BoardHandler boardHandler = new BoardHandler(); // =>힙에 보드핸들러 변수 생성.
    
    BoardHandler.keyScan = keyScan;
    
    
    while (true) {
      String command = prompt();

      if (command.equals("quit")) {
        break;

      } else if (command.equals("/lesson/add")) {
        lessonHandler.addLesson(); // addLesson() 메서드 블록에 묶어 놓은 코드를 실행한다.

      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();

      } else if (command.contentEquals("/member/add")) {
        memberHandler.addMember();

      } else if (command.equals("/member/list")) {
        memberHandler.listMember();

      } else if (command.equals("/board/add")) {
        boardHandler.addBoard(); //보드핸들러가 가리키는 인스턴스를 가지고 애드보드를 실행.
                                 //애드보드 메서드 앞에 있는 보드핸들러 주소를 찾아가 힙에 있는 메모리를 바꿈.
      } else if (command.equals("/board/list")) {
        boardHandler.listBoard();

      } else {
        System.out.println("해당 명령을 지원하지 않습니다");
      }

      System.out.println();

    }
  }

  static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine();
  }
  
  
}
  

  

  

