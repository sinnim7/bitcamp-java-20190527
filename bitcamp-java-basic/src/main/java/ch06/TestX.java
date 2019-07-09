package ch06;

public class TestX {

  public static void main(String[] args) {
//C:\Users\bit\git\bitcamp-java-20190527\bitcamp-java-basic>java -classpath ./bin/main 
//-Dname=hong -Dkor=100 -Deng=90 -Dmath=80 ch06.TestX
    
    String name = System.getProperty("name");
    int kor = Integer.parseInt(System.getProperty("kor"));
    int  eng = Integer.parseInt(System.getProperty("eng"));
    int math = Integer.parseInt(System.getProperty("math"));  
    
    int sum = kor + eng + math;
    
    
    System.out.printf("이름: %s\n", name);
    System.out.printf("국어: %s\n", kor);
    System.out.printf("영어: %s\n", eng);
    System.out.printf("수학: %s\n", math);
    System.out.printf("합계: %s\n", sum);
    System.out.printf("평균: %.1f\n", sum/3f);
    
  }

  
  /*
C:\Users\bit\git\bitcamp-java-20190527\bitcamp-java-basic>java -classpath ./bin/main -Dname=hong -Dkor=100 -Deng=90 -Dmath=80 ch06.TestX
이름: hong
국어: 100
영어: 90
수학: 80
합계: 270
평균: 90.0
   */
  
  
  
}
