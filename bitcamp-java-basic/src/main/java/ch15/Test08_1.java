// hash code 응용 - HashSet과 hashCode()
package ch15;

import java.util.HashSet;

public class Test08_1 {
  
    static class Student {
    String name;
    int age;
    boolean working;
    
    public Student(String name, int age, boolean working) {
      this.name = name;
      this.age = age;
      this.working = working;
    }
  }
  
  public static void main(String[] args) {
   Student s1 = new Student("홍길동", 20, false);
   Student s2 = new Student("홍길동", 20, false);
   Student s3 = new Student("임꺽정", 21, true);
   Student s4 = new Student("유관순", 22, true);
   System.out.println(s1 == s2);
   System.out.println(s1.hashCode()); //366712642 : 10진수 해시값
   System.out.println(s2.hashCode());
   System.out.println(s3.hashCode());
   System.out.println(s4.hashCode());
   System.out.println("================================");

   // 해시셋(집합)에 객체를 보관
   HashSet<Student> set = new HashSet<Student>();
   set.add(s1);
   set.add(s2);
   set.add(s3);
   set.add(s4);
   
   // 해시셋에 보관된 객체를 꺼낸다.
   Object[] list = set.toArray();
   for (Object obj : list) {
     Student student = (Student) obj;
     System.out.printf("%s, %d, %s\n",
         student.name, student.age, student.working ? "재직중" : "실업중");
   }
   
   // 집합?
   // => 중복 값을 저장할 수 없음.
   
   // HashSet
   // => 집합의 기능을 수행. 중복 값을 저장하지 않음.
   // => 저장할 객체에 대해 hash 코드로 중복 여부를 검사.
   // => 해시 값이 다르면 다른 값으로 취급.
   // => 또한 hash 코드로 값을 저장할 인덱스(위치)를 결정하기 때문에
   //    값을 꺼낼 때 저장한 순서대로 꺼낼 수 없음.
   
   // 현재 예제의 문제점?
   //   => S1과 S2는 같은 데이터를 갖고 있지만 다른 해시 코드를 리턴하기 때문에
   //      HashSet 입장에선 s1과 s2를 다른 값으로 취급.
   //   => 그래서 s1과 s2 모두 HashSet에 보관된 것.
   //
   // 해결책?
   //   => Student 클래스에서 hashCode()를 오버라이딩 해
   //      같은 데이터에 대해 같은 해시코드를 리턴하도록 만들어야 함.
   
   
   
  }
}



