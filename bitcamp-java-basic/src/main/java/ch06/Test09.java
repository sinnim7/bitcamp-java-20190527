// 메서드 - 로컬 변수의 생성과 소멸
package ch06;

public class Test09 {
  public static void main(String[] args) {    //메소드에서 사용할 로컬변수를 프레임이라고 함.
    int value = 100;
    m1(value);
    System.out.println(value);
    
    m1(value + 15);
    System.out.println(value);
    
    m1(value + 15); 
    System.out.println(value);
  }
  
  static void m1(int value) {     // m1에서 사용할 로컬변수를 프레임이라고함.ㄴ
    value = 200;
    System.out.printf("m1(): %d\n", value);  
  } // 메서드 끝나면 메모리 삭제 => value, 원래 값인 100으로 돌아감.
}

// 위 코드를 보고 로컬 변수를 모두 찾아 그 이름을 나열하라!
// 답: main() - value, args,  m1() - value

/*
# 로컬 변수의 생성 과 소멸
- 메서드가 호출될 때 생성된다.
- 메서드를 실행한 후 리턴 할 때 소멸된다.
 */

/*
 * 하드에서
1. 클래스 찾기
2. 바이트코드 여부 검증
3. 클래스코드를 메서드 에어리어(시험지)로 올림
4. 메인 메서드 호출

메인 메서드 호출하면
1. jvm 스택(답안지)에 로컬변수를 만든다(준비).
2. 메인에서 m1(100) 호출
3. 스택에 m1() 로컬변수를 준비.
4. m1()에 100아규먼트를 넣음.
*/








