// 예외 처리 연습 2 = 예외 처리 안했을 때

package ch21.g;

public class Test02_1 {

  public static void main(String[] args) {

    System.out.println(100 / 0);
    
    
    // RuntimeException에 대해선 컴파일러가 예외처리를 요구하지 않음.
    // 다만 예외가 발생하면 호출자에게 전달함.
    // 즉 여기서 예외가 발생하면 main()의 호출자인 JVM에게 전달함.
    
    System.out.println("종료!");
    
    
  }

}
