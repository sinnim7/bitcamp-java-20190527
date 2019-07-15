package ch13.f;

public class B extends A {
  private int v2 = 200;
  
  public B() { 
    super(); //<--자동으로 집어넣는다.
               // B의 수퍼 클래스? A 클래스이다. 즉 A 클래스의 기본 생성자를 호출한다. 여기에서야 A클래스로 감.
    System.out.println("B.B()");
  }
  
  public void m2() {
    System.out.printf("B.v2 = %d\n", this.v2);
  }
}
