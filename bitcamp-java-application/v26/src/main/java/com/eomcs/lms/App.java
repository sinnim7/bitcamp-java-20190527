// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행함.

package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.CalcPlusCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.HiCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Input;


public class App {

  static Scanner keyScan;

  public static void main(String[] args) throws Exception {

    keyScan = new Scanner(System.in);

    Deque<String> commandStack = new ArrayDeque<>(); 
    Queue<String> commandQueue = new LinkedList<>();

    Input input = new Input(keyScan); 

    // Command 객체를 보관할 Map 준비
    HashMap<String, Command> commandMap = new HashMap<>();

    ArrayList<Lesson> lessonList = new ArrayList<>();
    ArrayList<Member> memberList = new ArrayList<>();
    ArrayList<Board> boardList = new ArrayList<>();

    commandMap.put("/lesson/add", new LessonAddCommand(input, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(input, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(input, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(input, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(input, lessonList));

    commandMap.put("/member/add", new MemberAddCommand(input, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(input, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(input, memberList));
    commandMap.put("/member/list", new MemberListCommand(input, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(input, memberList));

    commandMap.put("/board/add", new BoardAddCommand(input, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(input, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(input, boardList));
    commandMap.put("/board/list", new BoardListCommand(input, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(input, boardList));
    
    commandMap.put("/hi", new HiCommand(input));
    commandMap.put("/calc/plus", new CalcPlusCommand(input));

    while (true) {
      String command = prompt();

      if (command.length() == 0)
        continue;
      commandStack.push(command); 
      commandQueue.offer(command);

      // 사용자가 입력한 명령어를 처리할 Command 객체를 Map에서 꺼냄.
      Command executor = commandMap.get(command);

      if (command.equals("quit")) {
        break;

      } else if (command.equals("history")) {
        printCommandHistory(commandStack);

      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue);

      } else if (executor !=null) {
        executor.execute(); 

      } else {
        System.out.println("해당 명령을 지원하지 않습니다");
      }
      
      System.out.println();
    }
  }

  private static void printCommandHistory(Iterable<String> list) throws Exception{ // 최신순으로 출력
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






