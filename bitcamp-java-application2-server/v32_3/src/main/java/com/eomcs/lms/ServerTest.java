package com.eomcs.lms;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTest {

  public static void main(String[] args) {
    System.out.println("[수업관리시스템 서버 애플리케이션 테스트]");

    try(Socket socket = new Socket("192.168.0.55", 8888);
        //192.168.0.55 비트컴 아이피주소. 아이피 확인 cmd창 ipconfig /all
      // 서버와의 입출력을 위해 객체를 준비
      // => 버퍼를 사용할 경우, 데이터를 보내는 쪽에선 추력 스트림을 먼저 준비하라!
      PrintWriter out = new PrintWriter(
          new BufferedOutputStream(socket.getOutputStream()));
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()))) {
      System.out.println("서버와 연결됨");
      
      
      
      // 서버에 출력.
      out.println("'신지하'입니다");
      out.flush(); // 주의! 버퍼로 출력한 내용을 서버로 보내도록 강제해야 함.
      System.out.println("서버로부터 데이터를 보냄.");
      
      // 서버가 보낸 데이터를 읽음.
      String response = in.readLine();
      System.out.println("서버로부터 데이터를 받음.");
      
      // 서버가 보낸 데이터를 콘솔창에 출력.
      System.out.println("-->" + response);


    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("서버와 연결 끊음.");
  }
}
