package ch12.d;

public class Patient {
  
  public static final int WOMAN = 1;   ///상수 선언
  public static final int MAN = 2;
  
  String name;
  int age;
  int weight;
  int height;
  int gender;
  
  public String toString() { //this 생략함.
    return String.format("name=%s, age=%d, height=%d, weight=%d, gender=%d"
            , this.name, this.age, this.height, this.weight, this.gender);
  }
  
  
  

}
