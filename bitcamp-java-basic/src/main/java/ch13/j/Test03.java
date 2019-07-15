// 추상 클래스: 파라미터로 사용하기
package ch13.j;

public class Test03 {

  public static void main(String[] args) {
    
    DumpTruck car = m1();
    Car car2 = m2();
    
  }
    
    static DumpTruck m1() {
      // 이 메서드의 리턴 값은
      // DumpTruck 인스턴스 (주소) 이거나
      // DumpTruck의 하위 클래스의 인스턴스.
      return new DumpTruck();
    }
    
    static Car m2() {
      // 이 메서드의 리턴 값은 Car의 인스턴스가 아님.
      // 왜? Car는 추상클래스라서 인스턴스를 생성할 수 없음.
      // 그럼? Car의 하위 클래스의 인스턴스를 리턴한다는 얘기.
      return new DumpTruck();
      
    }
    
    

  
 
  
}
