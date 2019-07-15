// super 키워드 
package ch14.b;

public class C extends A {
  
  @Override public void m1(int a) {
    System.out.println("C.m1()");
    // 오버라이딩 전의 메서드를 호출하고 싶다면 super 레퍼런스를 사용하라!
    
    super.m1(a); 
  } 
  
  public void m4() {
    System.out.println("C.m4()");
    this.m1(100); //=> super.m1(a) => A클의  void m1(int a) { System.out.println("A.m1()");
    this.m2("okok", 100); //=> A클의 protected void m2(String a, int b) { System.out.println("A.m2()");
    super.m2("haha", 200); //=> A클의 protected void m2(String a, int b) {  System.out.println("A.m2()");
  }
  
  public static void main(String[] args) {
    C obj = new C();
    obj.m4();  // 1번 => System.out.println("C.m1()");
  }
  
}

/*
this.메서드명();
=> this에 저장된 인스턴스의 클래스에서부터 메서드를 찾아 올라감.


super.메서드명();
=> 수퍼클래스에서부터 메서드를 찾아 올라감.

*/




