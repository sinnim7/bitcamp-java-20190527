// 애플리케이션 예외의 종류: main()과 RuntimeException
package ch21.c;

import java.util.Scanner;

public class Test01_3 {

  public static void main(String[] args) {


    // RuntimeException을 발생시키는 메서드를 호출할 때
    // 예외 처리 코드를 작성하지 않더라도
    // 컴파일러는 에러를 띄우지 않음.

    // 하지만 RuntimeException 예외를 처리하지 않으면
    // 최종적으로 JVM에 전달되고, 즉시 프로그램을 종료해서
    // 프로그램을 종료하기 싫으면 RuntimeException에 대해서도
    // 예외처리를 하라!


    // 아래 코드에서 예외가 발생한다면 RuntimeException 에외다
    // 따라서 try ~ catch ~ 블록을 사용하지 않아도 컴파일러가 에러를 띄우지는 않음.
    // 그러나 예외는 예외라서 발생하는 순간 호출자에게 전달됨.
    // main()에서 발생된 예외는 JVM에게 바로 전달되기 때문에
    // 즉식 실행을 멈출 거시.
    // 그래서 예외처리가 강제 ㅎ상항이 아니라 할지라도
    // 이렇게 try ~ catch ~ 로 처리해야 함.


    Scanner keyScan = new Scanner(System.in);

    while (true) {
      try {

        System.out.println("값1? ");
        int a = Integer.parseInt(keyScan.nextLine());

        System.out.println("값2? ");
        int b = Integer.parseInt(keyScan.nextLine());

        System.out.println(divide(a, b));
      } catch (RuntimeException e) {
        System.out.println("입력 또는 계산 중 오류 발생!");
      }

    }

  }

  static int divide(int a, int b) throws RuntimeException {
    if (b == 0)
      throw new RuntimeException("0으로 나눌 수 없습니다.");
    return a / b;
  }


}
