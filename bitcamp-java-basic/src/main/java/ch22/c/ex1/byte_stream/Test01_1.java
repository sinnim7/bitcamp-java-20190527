// 버퍼 사용 - 사용 전
// 
package ch22.c.ex1.byte_stream;

import java.io.FileInputStream;

public class Test01_1 {
  public static void main(String[] args) throws Exception{
    
      FileInputStream in = new FileInputStream("temp/jls12.pdf");
      
      System.out.println("데이터 읽는 중...");
      
      long start = System.currentTimeMillis();
      
      int b;
      int count = 0;
      while ((b = in.read()) != -1) {
        count++;
      }
      
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      System.out.println(count);
      
      in.close();
    
    System.out.println("출력 완료!");
  }
}








