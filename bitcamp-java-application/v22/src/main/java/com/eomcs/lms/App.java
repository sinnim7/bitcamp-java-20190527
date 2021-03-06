// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행함.

package com.eomcs.lms;


import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Input;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

// 임포트 라인수가 늘어나도 컴파일러에게 알려주는 것이기에 문제 없음.

public class App {
  
  
  static Scanner keyScan;
  static Stack<String> commandStack = new Stack<>(); 
  static Queue<String> commandQueue = new Queue<>();

  
  public static void main(String[] args) throws Exception {
    
    
    
    keyScan = new Scanner(System.in);
    
    // input 생성자를 통해 input이 의존하는 객체인 Scanner를 주입.
    Input input = new Input(keyScan); //생성자의 파라미터는 인스턴스에 필요한 값을 넣는다.
    
    
    //각 핸들러의 생성자를 통해 의존 객체 "Input"을 주입.
    //=> 이렇게 어떤 객체가 필요로 하는 의존 객체를 주입하는 걸 
    //  "의존성 주입(Dependency Injection; DI)"라고 함.
    //=> DI를 전문적으로 처리해주는 프레임워크가 있으니 그 이름도 유명한
    //  Spring Ioc 컨테이너!
    
    
    LessonHandler lessonHandler = new LessonHandler(input);
    
    MemberHandler memberHandler = new MemberHandler(input);  //인스턴스로 만든 건 한개 만들더라도 나중에 여러개를 만들때를 대비.(스태틱 아님)
                                                        //인스턴스 필드를 쓰는 이유.스태틱은 힙에 메모리가 한개밖에 만들지못함.
                                                       //인스턴스가 하나라면 클래스 이름과 같게(소문자로 시작)
    BoardHandler boardHandler = new BoardHandler(input); // =>힙에 보드핸들러 변수 생성.
    
    
    
    
    while (true) {
      String command = prompt();
      
      commandStack.push(command); //사용자가 입력한 명령을 보관.
      commandQueue.offer(command);
      
      if (command.equals("quit")) {
        break;

      } else if (command.equals("history")) {
        printCommandHistory();
        
      } else if (command.equals("history2")) {
        printCommandHistory2();
        
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

  private static void printCommandHistory() throws Exception{ // 최신순으로 출력
    Stack<String> stack = commandStack.clone(); //명령어가 들어있는 커맨드스택에서 값을 꺼내기 전에 먼저 복제.
    //원래 명령이 다 삭제되는 걸 방지하려고 원본 스택을 복제.
    int count = 0;  
    while (!stack.empty()) {//스택에 저장된 명령어가 다 나올 때까지출력
      System.out.println(stack.pop());
      if (++count % 5 == 0) { //카운트값이 5배수일때마다
        System.out.println(":"); //화면에 콜론 출력
        if (keyScan.nextLine().equalsIgnoreCase("q")) //대소문자구분없이q라면
          break;    //출력 멈춤.
      }
    }
  }

  
  
  
  
  
  
  
  
  
  
  
  private static void printCommandHistory2() throws Exception{
    Queue<String> queue = commandQueue.clone();
    int count = 0;
    while (!queue.empty()) {
      System.out.println(queue.poll());
      if (++count % 5 == 0) {
        System.out.print(":");
        if (keyScan.nextLine().equalsIgnoreCase("q"))
          break;
      }
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine();
  }
  
  
}
  

  

  

