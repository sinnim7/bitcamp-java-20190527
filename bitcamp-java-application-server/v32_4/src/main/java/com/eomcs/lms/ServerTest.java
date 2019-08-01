package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  public static void main(String[] args) {
    System.out.println("[수업관리시스템 서버 애플리케이션 테스트]");

    try(Socket socket = new Socket("192.168.0.55", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){

      // 서버에 전송할 객체 준비.
      Member member = new Member();
      member.setNo(1);
      member.setName("홍길동");
      member.setEmail("hong@test.com");
      member.setPhoto("hong.gif");
      member.setTel("1111-1111");


      // 서버에 객페를 전송
      out.writeObject(member);
      out.flush(); // 주의! 버퍼로 출력한 내용을 서버로 보내도록 강제해야 함.
      System.out.println("서버로부터 데이터를 보냄.");

      // 서버가 보낸 데이터를 읽음.
      String response = in.readUTF();
      System.out.println("서버로부터 데이터를 받음.");

      // 서버가 보낸 데이터를 콘솔창에 출력.
      System.out.println("-->" + response);


    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("서버와 연결 끊음.");
  }
}
