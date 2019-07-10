// 클래스 사용 후
package ch07;

public class Test03 {
  // 학생의 성적 데이터를 담을 새로 구조의 메모리를 정의한다.
  // 문법:
  //      class 새데이터타입이름 {
  //        변수 선언;
  //        ...
  //      }
  // - 새데이터타입의이름 : 대문자로 시작하고, 단어의 시작도 대문자로 작성한다. 보통 명사형으로 짓는다.
  //
  static class Score {   //score 정보를 담을 메모리를 설계.
    String name;  // 설계 도면이기 때문에 변수가 존재하는 상태가 아니다.
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  public static void main(String[] args) throws Exception {
    
    // 설계 도면 대로 변수를 준비한다.
    // => 새 데이터 타입에 따라 변수를 준비한다.
    // => 클래스에 정의된 대로 변수를 준비한다.
    // => 클래스의 "인스턴스(instance)"를 생성한다.
    // => 문법:
    //          new 클래스명();
    // => 클래스 설계도에 따라 준비한 변수를 사용하려면 그 메모리의 주소가 있어야 한다.
    // => 클래스의 인스턴스 주소를 저장할 변수를 생성하는 문법:
    //          클래스명 변수명;
    
    Score s1;  // Score 설계도에 따라 준비한 메모리(변수들)의 주소를 저장하는 변수 
               // 이렇게 주소를 저장하는 변수를 "레퍼런스(reference)"라 부른다.
    s1 = new Score(); // Score 설계도에 따라 힙에 메모리(변수들)를 준비시킨다.
                      // 그리고 메모리의 시작주소를 리턴하는데 그걸 레퍼런스라고 부르는 것에 저장한다.
                      //이때 힙에 만들어진 걸 인스턴스, 스코어의 인스턴스.
    
    //안스턴스 새로 만드는법@@
    Class c = Class.forName("ch07.Test03$Score");//() 안 클래스를 찾아가 클래스를 로딩하고 jvm은 클래스 정보를 메모리에 보관. 메모리 주소가 c에 리턴. 
    //@@@@대문자임! socre 모든 정보를 따로 만든다.
    //$는 socre클래스가 test03 클래스 안에 있다는 얘기. 이걸 중첩 클래스라고 함.
    //이걸 문자열로 가르키려면 ch07.Test03$Score 해야 함. 확장자명을 적지 않음.
    //Class는 class를 다루는 클래스임.
    Score s3 = (Score)c.newInstance();//newInstance()는 클래스 정보를 가지고 인스턴스를 만듦. 
                                    //힙에 스코어 인스턴스를 만들어 주소를 리턴함.
                                     //
    
    // 물론 다음과 같이 한 줄에 표현할 수도 있다.
    Score s2 = new Score();
    
    // 새 데이터 타입에 따라 만든 메모리에 값 넣기 
    // => Score 클래스의 인스턴스에 값 넣기
    // => 문법:
    //      레퍼런스.변수명 = 값;
    //
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 90;
    s2.math = 90;
    
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 80;
    s3.math = 80;
    
    // 메서드에 새 데이터 타입으로 만든 메모리의 주소를 전달한다.
    // => 값이 아니라 메모리의 주소를 전달한다! "call by reference"
    printScore(s1); // 이전 예제처럼 여러 개의 값을 넘겨줄 필요가 없다. 아주 편리하다.
    
    printScore(s2);
    
    printScore(s3);
  }
  
  // 새 데이터 타입의 메모리 주소를 받을 변수를 파라미터로 선언한다.
  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    System.out.printf("%s: %d, %d, %d, %d, %f\n", 
        s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
  
}

/*
# 자바 기본 데이터 타입의 변수 선언 vs 클래스의 변수 선언
- 자바 기본 데이터 타입은 변수를 선언하는 순간 메모리에 생성된다.
    int a;  // 바로 int 값을 저장할 메모리가 준비된다.
- 클래스의 변수 선언은 주소를 담는 레퍼런스이다. 따라서 주소를 담는 메모리만 준비된다.
    Score s;  // 아직 Score 설계도에 따라 변수들이 준비된 상태가 아니다.
- 클래스의 설계도에 따라 메모리를 준비하려면 따로 new 명령을 사용해야 한다.
    new Score();
- 생성된 메모리를 사용하려면 주소를 잘 보관해 두어야 한다.
    s = new Score();
    
 */















