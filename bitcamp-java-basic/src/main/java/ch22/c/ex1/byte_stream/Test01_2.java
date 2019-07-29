// 버퍼 사용 - 사용 후
// 
package ch22.c.ex1.byte_stream;

import java.io.FileInputStream;

public class Test01_2 {
  public static void main(String[] args) {
    
    try {
      FileInputStream in = new FileInputStream("temp/jls12.pdf");
      
      System.out.println("데이터 읽는 중...");
      
      long start = System.currentTimeMillis();
      
      byte[] buf = new byte[8192]; //현업에선 보통 8키로바이트 정도로 설정.
      int len = 0;
      int count = 0;
      while ((len = in.read(buf)) != -1) {
        count++;
        
        // 파일에서 읽은 1바이트를 암호화한다고 가정해 보자.
        // 바이트 배열에 데이터를 읽어 왔으면
        // 다음과 같이 바이트 배열을 반복해 작업을 수행해야 함.
        // 1 바이트를 읽었으면 암호화한다고 가정하자.
        // 그러면 여기에 그 암호화하는 코드를 작성해야 함.
        for (int i = 0; i < len; i++) {
          // 각 바이트를 암호화시키는 코드를 여기에 작성해야 함.
          // 데이터를 읽는 속도를 높이기 위해 바이트 배열 단위로 읽는 건 좋지만
          // 반복문 안에 반복문을 넣고 코드를 작성해야 하는 불편함이 생김.
          // 해결책? Test01_3.java를 확인하라!.
        }
       
        
      }
      
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      System.out.println(count);
      
      in.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }
}








