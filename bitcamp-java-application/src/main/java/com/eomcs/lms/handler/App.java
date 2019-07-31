// v1 : 스태틱 필드와 메서드를 인스턴스 필드와 메서드로 전환해 코드를 정리.
package com.eomcs.lms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

  Scanner keyScan;

  ArrayList<Lesson> lessonList = new ArrayList<>();
  LinkedList<Member> memberList = new LinkedList<>();
  ArrayList<Board> boardList = new ArrayList<>();


  private void service() {

    loadLessonData();
    loadMemberData();
    loadBoardData();

    keyScan = new Scanner(System.in);

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    Input input = new Input(keyScan);

    HashMap<String, Command> commandMap = new HashMap<>();

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

      Command executor = commandMap.get(command);

      if (command.equals("quit")) {
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack);

      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue);

      } else if (executor != null) {
        executor.execute();

      } else {
        System.out.println("해당 명령을 지원하지 않습니다!");
      }

      System.out.println();
    } // while

    saveLessonData();
    saveMemberData();
    saveBoardData();
  }


  private void printCommandHistory(Iterable<String> list) {
    Iterator<String> iterator = list.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count % 5 == 0) {
        System.out.print(":");
        if (keyScan.nextLine().equalsIgnoreCase("q"))
          break;
      }
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine();
  }

  @SuppressWarnings("unchecked")
  private void loadLessonData() {
    File file = new File("./lesson.ser");

    FileInputStream in = null;
    ObjectInputStream in2 = null;

    try {
      in = new FileInputStream(file);

      in2 = new ObjectInputStream(in);

      lessonList = (ArrayList<Lesson>) in2.readObject();

    } catch (FileNotFoundException e) {
      System.out.println("읽을 파일을 찾을 수 없습니다!");

    } catch (Exception e) {
      System.out.println("파일을 읽는 중에 오류가 발생했습니다!");

    } finally {
      try {
        in2.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private void saveLessonData() {

    File file = new File("./lesson.ser");

    FileOutputStream out = null;
    ObjectOutputStream out2 = null;

    try {
      out = new FileOutputStream(file);

      out2 = new ObjectOutputStream(out);

      out2.writeObject(lessonList);

    } catch (FileNotFoundException e) {
      System.out.println("파일을 생성할 수 없습니다!");

    } catch (IOException e) {
      System.out.println("파일에 데이터를 출력하는 중에 오류 발생!");
      e.printStackTrace();

    } finally {
      try {
        out2.close();
      } catch (Exception e) {
      }
      try {
        out.close();
      } catch (Exception e) {
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void loadMemberData() {
    File file = new File("./member.ser");

    FileInputStream in = null;
    ObjectInputStream in2 = null;

    try {
      in = new FileInputStream(file);

      in2 = new ObjectInputStream(in);

      memberList = (LinkedList<Member>) in2.readObject();

    } catch (FileNotFoundException e) {
      System.out.println("읽을 파일을 찾을 수 없습니다!");

    } catch (Exception e) {
      System.out.println("파일을 읽는 중에 오류가 발생했습니다!");

    } finally {
      try {
        in2.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private void saveMemberData() {
    File file = new File("./member.ser");

    FileOutputStream out = null;
    ObjectOutputStream out2 = null;

    try {
      out = new FileOutputStream(file);

      out2 = new ObjectOutputStream(out);

      out2.writeObject(memberList);



    } catch (FileNotFoundException e) {
      System.out.println("파일을 생성할 수 없습니다!");

    } catch (IOException e) {
      System.out.println("파일에 데이터를 출력하는 중에 오류 발생!");
      e.printStackTrace();

    } finally {
      try {
        out2.close();
      } catch (Exception e) {
      }
      try {
        out.close();
      } catch (Exception e) {
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser");

    FileInputStream in = null;
    ObjectInputStream in2 = null;

    try {
      in = new FileInputStream(file);

      in2 = new ObjectInputStream(in);

      boardList = (ArrayList<Board>) in2.readObject();

    } catch (FileNotFoundException e) {
      System.out.println("읽을 파일을 찾을 수 없습니다!");

    } catch (Exception e) {
      System.out.println("파일을 읽는 중에 오류가 발생했습니다!");

    } finally {
      try {
        in2.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private void saveBoardData() {

    File file = new File("./board.ser");

    FileOutputStream out = null;
    ObjectOutputStream out2 = null;

    try {
      out = new FileOutputStream(file);

      out2 = new ObjectOutputStream(out);

      out2.writeObject(boardList);
    } catch (FileNotFoundException e) {
      System.out.println("파일을 생성할 수 없습니다!");

    } catch (IOException e) {
      System.out.println("파일에 데이터를 출력하는 중에 오류 발생!");
      e.printStackTrace();

    } finally {
      try {
        out2.close();
      } catch (Exception e) {
      }
      try {
        out.close();
      } catch (Exception e) {
      }
    }
  }

  public static void main(String[] args) {
    App app = new App();
    app.service();
  }
}
