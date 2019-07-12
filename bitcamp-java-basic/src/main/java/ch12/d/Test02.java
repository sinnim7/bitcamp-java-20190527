//캡슐화(encapsulation) : 적용 후

package ch12.d;



public class Test02 {
  

  public static void main(String[] args) {
    
    Patient2 p = new Patient2();
    p.setName("김영희");
    p.setAge(20);
    p.setWeight(60);
    p.setHeight(157);
    p.setGender(Patient.WOMAN);
    
    System.out.println(p);  //스트링 경우 자동으로 투스트링이 적용됨.
    
    
    Patient2 p2 = new Patient2();
    p2.setName("이철희");
    p2.setAge(300);  
    p2.setWeight(-50); // 캡슐화를 무너뜨릴 수 잇는 유효하지 않은 값은 무시됨.
    p2.setHeight(400);
    p2.setGender(Patient.MAN);
    
    System.out.println(p2);  //스트링 경우 자동으로 투스트링이 적용됨.
    
    //위의 p2 인스턴스를 보면,
    //나이가 300이면 환자가 아니라 몬스터.
    //몸무게가 -50이면 이해 불가.
    //키가 4m이면 나무다.
    //즉 patient 클래스는 환자 데이터를 저장할 목적으로 정의한 클래스인데
    //환자 데이터와 무관한 몬스터 데이터를 저장하고 있다.
    //차라리 클래스 이름을 Monster로 변경하는 게 바람직.
    //이렇게 클래스 목적에 맞지 않는 데이터가 들어 갈 수 있다면,
    //"추상화"가 무너지게 됨.
    //이를 방지하기 위해선 클래스 목적(추상화 목적)에 맞춰
    //인스턴스 변수에 무효한 값이 들어가지 않도록 해야 함.
    //그럴 목적으로 만든 문법이 캡슐화이다.
    
    //"캡슐화"란 추상화가 무너지지 않도록 인스턴스 멤버(변수와 메서드)의 접근을 제어하는 문법.
    //"추상화"란 실세계의 객체를 프로그램에서 다룰 수 있도록 클래스로 정의하는 것.
    //추상화 기법?
    //-데이터 타입을 정의
    //-유관 메서드를 묶기
    
    
    
    
    
    
  }

}
