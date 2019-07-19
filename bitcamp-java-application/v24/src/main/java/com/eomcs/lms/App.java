// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행함.

package com.eomcs.lms;


import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;
import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

// 임포트 라인수가 늘어나도 컴파일러에게 알려주는 것이기에 문제 없음.

public class App {
  
  static Scanner keyScan;
  
  public static void main(String[] args) throws Exception {
    
    keyScan = new Scanner(System.in);
    
    //명령어를 저장하는 컬렉션(collection)
    Stack<String> commandStack = new Stack<>(); 
    Queue<String> commandQueue = new Queue<>();
    
    // input 생성자를 통해 input이 의존하는 객체인 Scanner를 주입.
    Input input = new Input(keyScan); //생성자의 파라미터는 인스턴스에 필요한 값을 넣는다.
    
    //각 핸들러의 생성자를 통해 의존 객체 "Input"을 주입.
    //=> 이렇게 어떤 객체가 필요로 하는 의존 객체를 주입하는 걸 
    //  "의존성 주입(Dependency Injection; DI)"라고 함.
    //=> DI를 전문적으로 처리해주는 프레임워크가 있으니 그 이름도 유명한
    //  Spring Ioc 컨테이너!
    
    LessonHandler lessonHandler = new LessonHandler(input, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(input, new LinkedList<>()); 
    BoardHandler boardHandler = new BoardHandler(input, new ArrayList<>()); 

    while (true) {
      String command = prompt();
      
      // 사용자가 아무것도 입력하지 않았으면 다시 입력받음.
      if (command.length() == 0)
        continue;
      commandStack.push(command); //사용자가 입력한 명령을 보관.
      commandQueue.offer(command);
      
      if (command.equals("quit")) {
        break;

      } else if (command.equals("history")) {
        printCommandHistory(commandStack.clone());
        
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.clone());
        
      } else if (command.equals("/lesson/add")) {
        lessonHandler.addLesson(); // addLesson() 메서드 블록에 묶어 놓은 코드를 실행한다.

      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();
        
      } else if (command.equals("/lesson/detail")) {
        lessonHandler.detailLesson();
        
      } else if (command.equals("/lesson/update")) {
        lessonHandler.updateLesson();
        
      } else if (command.equals("/lesson/delete")) {
        lessonHandler.deleteLesson();
        
      } else if (command.contentEquals("/member/add")) {
        memberHandler.addMember();

      } else if (command.equals("/member/list")) {
        memberHandler.listMember();

      } else if (command.equals("/member/detail")) {
        memberHandler.detailMember();

      } else if (command.equals("/member/update")) {
        memberHandler.updateMember();

      } else if (command.equals("/member/delete")) {
        memberHandler.deleteMember();
      
      } else if (command.equals("/board/add")) {
        boardHandler.addBoard(); //보드핸들러가 가리키는 인스턴스를 가지고 애드보드를 실행.
                                 //애드보드 메서드 앞에 있는 보드핸들러 주소를 찾아가 힙에 있는 메모리를 바꿈.
      } else if (command.equals("/board/list")) {
        boardHandler.listBoard();

      } else if (command.equals("/board/detail")) {
        boardHandler.detailBoard();

      } else if (command.equals("/board/update")) {
        boardHandler.updateBoard();

      } else if (command.equals("/board/delete")) {
        boardHandler.deleteBoard();

      } else {
        System.out.println("해당 명령을 지원하지 않습니다");
      }
      System.out.println();
    }
  }

  private static void printCommandHistory(com.eomcs.util.Iterable<String> list) throws Exception{ // 최신순으로 출력
    Iterator<String> iterator = list.iterator();
    int count = 0;  
    while (iterator.hasNext()) {//스택에 저장된 명령어가 다 나올 때까지출력
      System.out.println(iterator.next());
      if (++count % 5 == 0) { //카운트값이 5배수일때마다
        System.out.println(":"); //화면에 콜론 출력
        if (keyScan.nextLine().equalsIgnoreCase("q")) //대소문자구분없이q라면
          break;    //출력 멈춤.
      }
    }
  }


  private static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine();
  }
  
  
}
  

  

  

