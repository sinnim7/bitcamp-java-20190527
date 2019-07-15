// String 클래스 사용법 
package ch11;

public class Test01 {
  public static void main(String[] args) {
    // String 레퍼런스
    // => String은 자바 기본 타입이 아니다. 
    // => 클래스이다.
    String s1; // s1은 String 인스턴스 주소를 담는 레퍼런스이다.
    
    // String 인스턴스
    s1 = new String("Hello"); // 힙에 Hello 문자 코드를 저장할 메모리를 만들고 그 주소를 리턴한다.
    
    
    String s2 = new String("Hello");
    
    
    String a = new String("a");
    String b = new String("a");
    
    String c = "a";
    String d = "a";
    
    if (s1 == s2)  //  == 주소가 같냐??
      System.out.println("같다");
    else
      System.out.println("다르다"); //주소가 다름.
    
    if (a == b)
      System.out.println("같다");
    else
      System.out.println("다르다"); //주소가 다름.
    
    if (c == d)
      System.out.println("같다"); //같다
    else
      System.out.println("다르다");
    
    if (a == c)
      System.out.println("같다"); 
    else
      System.out.println("다르다"); //다르다
    
  }
}
















