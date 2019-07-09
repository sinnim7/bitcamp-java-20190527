package ch06;

public class Testx14 {

  public static void main(String[] args) {
 // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // $ java -cp ./bin/main ch06.Test15 홍길동 100 100 90

    
      
      System.out.printf("이름: %s\n", args[0]);
      
      int sum = 0;
      for(int i=1; i<args.length; i++) 
        sum += Integer.parseInt(args[i]);
        System.out.printf("합계: %d\n", sum);
        System.out.printf("평균: %.1f\n", sum/(args.length-1f)); //96.7
      //System.out.printf("평균: %s\n", (float)sum/(args.length)); // 96.666664
    
        
    /*
C:\Users\bit\git\bitcamp-java-20190527\bitcamp-java-basic>
java -classpath bin/main ch06.Testx14 hong 100 90 100
이름: hong
합계: 290
평균: 96.666664
     */
    
        /* @@이클립스 터미널 사용시
         * bit@DESKTOP-SBEN96E MINGW64 ~/git/bitcamp-java-20190527/bitcamp-java-basic (master)
$ java -classpath bin/main ch06.Testx14 hong 100 100 90
         */
        
        
        
  }

}
