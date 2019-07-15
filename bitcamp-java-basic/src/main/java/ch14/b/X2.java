package ch14.b;

public class X2 extends X1 {
  @Override
  void m1() {
    System.out.println("X2.m1()");
  }
  
void test() {
    
    //this에 저장된 인스턴스 주소에 클래스부터 m1()을 찾아 호출.
    // => this가 가리키는 객체(인스턴스)의 클래스부터 m1()을 찾아 호출함.
    // => this 객체의 타입부터 m1()을 찾아 호출함.
    // => this의 타입부터 m1()을 찾아 호출함.
    // 만약 메서드가 없다면 그 상위 클래스로 찾아 올라감.
    this.m1();
    
    
    // 이 메서드가 있는 현재 클래스의 수퍼 클래스부터 m1()을 찾아 올라감.
    // X2에 테스트 메서드가 있으니까 수퍼는 X1임.
    // X3에 테스트 메서드가 있었다면 수퍼는 X2임.
    
    super.m1();
  }
 
    
  }
 
  
  
  
  
