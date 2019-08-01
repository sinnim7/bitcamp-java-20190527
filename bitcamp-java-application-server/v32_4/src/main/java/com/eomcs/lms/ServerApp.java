// v32_4 : 클라이언트와 서버 간 데이터 주고 받기 2 - 인스턴스 주고 받기
package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  public static void main(String[] args) {
    System.out.println("수업관리시스템 서버 애플리케이션!");
   
    try(ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      try (Socket clientSocket = serverSocket.accept();
          ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
         
          ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())){
         
         
        System.out.println("클라이언트와 연결됨");
        
        // 클라이언트가 보낸 serialized 된 인스턴스 데이터를 읽는다.
        Member member = (Member)in.readObject();
        System.out.println("클라이언트가 객체를 읽음.");
        
        // 클라이언트가 보낸 객체의 내용이 궁금. 서버 쪽 콘솔 창에 출력해 보자
        System.out.println(member);
        
        //클라이언트에게 데이터를 잘 받았다고 응답.
        out.writeUTF("ok");
        out.flush();
        
        System.out.println("클라이언트로 데이터를 보냄");
        
        
      }
      
      System.out.println("클라이언트와 연결 끊음");

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e){
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }
}
