package ch14.a;

import javax.annotation.Syntax;

public class Score2 extends Score {
  protected int music;
  protected int art;
  
  // 오버라이딩(overriding)?
  // => 상속 받은 메서드를 서브 클래스의 역할에 맞게 재정의하는 문법
  // => 상속 받은 메서드와 똑 같은 시그너처(메서드 이름, 리턴타입, 파라미터 선언)로 메서드를 정의한다.
  // => 오버라이딩 메서드는 원래 메서드보다 접근 범위가 같거나 커야 함.
  //    원래 메서드보다 접근 범위가 주어들면 안 됨.
  
  @Override // 컴파일러에게 상속 받은 메서드를 재정의 한다는 것을 알려준다. 
  
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  
    
    
  }
}
