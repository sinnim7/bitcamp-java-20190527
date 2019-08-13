// client-v37_2 : '규칙2' 프로토콜에 따라 서버가 요구하는 파라미터 값을 사용자로부터 입력 받아 보내기.
package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ClientApp {

  Scanner keyBoard;

  private void service() {

    keyBoard = new Scanner(System.in);

    System.out.print("서버? ");
    String host = keyBoard.nextLine();

    System.out.print("포트? ");
    int port = Integer.parseInt(keyBoard.nextLine());


    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    System.out.println("애플리케이션 서버에 연결 중...");
    // 애플리케이션 서버에 연결함.

    try (Socket socket = new Socket(host, port);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      System.out.println("애플리케이션 서버에 연결됨!");

      while (true) {
        String command = prompt();
        if (command.length() == 0)
          continue;

        commandStack.push(command);
        commandQueue.offer(command);

        if (command.equals("quit") || command.equals("serverstop")) {
          // 서버에 quit 또는 serverstop 명령을 보내고 종료.
          send(command, out);
          break;

        } else if (command.equals("history")) {
          printCommandHistory(commandStack);

        } else if (command.equals("history2")) {
          printCommandHistory(commandQueue);

        } else {
          // 서버에 명령어를 보냄.
          send(command, out);
          // 서버의 응답을 처리함.
          receive(in, out);
        }
        System.out.println();
      } // while

      System.out.println("애플리케이션 서버와 연결 끊음!");

    } catch (Exception e) {
      System.out.println("애플리케이션 서버와 통신 오류!");
      e.printStackTrace();
    }
  }

  private void send(String command, PrintStream out) throws Exception {
    out.println(command);
    out.flush();

  }

  private void receive(BufferedReader in, PrintStream out) throws Exception {
    while (true) {
      String response = in.readLine();
      if (response.equals("!end!")) {
        break;
      } else if (response.equals("!{}!")) {
        send(keyBoard.nextLine(), out);
      } else {
        System.out.println(response);
      }
    }
  }


  private void printCommandHistory(Iterable<String> list) {
    Iterator<String> iterator = list.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count % 5 == 0) {
        System.out.print(":");
        if (keyBoard.nextLine().equalsIgnoreCase("q"))
          break;
      }
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    return keyBoard.nextLine();
  }

  public static void main(String[] args) {
    ClientApp app = new ClientApp();
    app.service();
  }
}


