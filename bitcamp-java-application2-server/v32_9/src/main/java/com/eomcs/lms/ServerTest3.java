package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class ServerTest3 {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  public static void main(String[] args) throws Exception {
    System.out.println("[수업관리시스템 서버 애플리케이션 테스트]");

    try (Socket socket = new Socket("192.168.0.55", 8888); // "localhost"

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음.");

      // 다른 메서드가 입출력 객체를 사용할 수 있도록 스태틱 변수에 저장.
      ServerTest3.in = in;
      ServerTest3.out = out;

      Board Board = new Board();
      Board.setNo(1);
      Board.setContents("제목1");
      

      if (!add(Board)) {
        error();
      }
      System.out.println("------------------");

      Board = new Board();
      Board.setNo(2);
      Board.setContents("제목2");

      if (!add(Board)) {
        error();
      }
      System.out.println("------------------");

      if (!list()) {
        error();
      }
      System.out.println("------------------");

      if (!delete()) {
        error();
      }
      System.out.println("------------------");

      if (!list()) {
        error();
      }
      System.out.println("------------------");

      if (!detail()) {
        error();
      }
      System.out.println("------------------");

      Board = new Board();
      Board.setNo(1);
      Board.setContents("오호라?");

      if (!update(Board)) {
        error();
      }
      System.out.println("------------------");

      if (!list()) {
        error();
      }
      System.out.println("------------------");

      if (!quit()) {
        error();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("서버와 연결 끊음.");
  }


  private static void error() throws Exception {
    System.out.printf("오류 : %s\n", in.readUTF());
  }

  private static boolean quit() throws Exception { // 입출력예외, 요청처리예외. 유지보수 위해 적어둠.
    out.writeUTF("quit");
    out.flush();
    System.out.print("quit 요청함. ==>");

    if (!in.readUTF().equals("ok"))
      return false;

    System.out.println("처리 완료!");
    return true;
  }

  private static boolean delete() throws Exception {
    out.writeUTF("/Board/delete");
    out.writeInt(2);
    out.flush();
    System.out.print("delete 요청함. ==> ");

    if (!in.readUTF().equals("ok"))
      return false;

    System.out.println("처리 완료!");
    return true;
  }

  private static boolean detail() throws Exception {
    out.writeUTF("/Board/detail");
    out.writeInt(1); // 회원번호 1번.
    out.flush();
    System.out.print("detail 요청함. ==> ");

    if (!in.readUTF().equals("ok"))
      return false;

    System.out.println("처리 완료!");
    System.out.println(in.readObject());

    return true;
  }

  private static boolean update(Board obj) throws Exception {
    out.writeUTF("/Board/update");
    out.writeObject(obj); // 회원번호 1번.
    out.flush();
    System.out.print("update 요청함. ==> ");

    if (!in.readUTF().equals("ok"))
      return false;

    System.out.println("처리 완료!");
    return true;
  }

  private static boolean list() throws Exception {
    out.writeUTF("/Board/list");
    out.flush();
    System.out.print("list 요청함. ==> ");

    if (!in.readUTF().equals("ok"))
      return false;

    System.out.println("처리 완료!");


    @SuppressWarnings("unchecked")
    List<Board> list = (List<Board>) in.readObject();
    System.out.println("------------------");
    for (Board obj : list) {
      System.out.println(obj);
    }
    return true;
  }

  private static boolean add(Board obj) throws Exception {
    out.writeUTF("/Board/add");
    out.writeObject(obj);
    out.flush();
    if (!in.readUTF().equals("ok"))
      return false;

    System.out.println("처리 완료!");
    return true;
  }


}


