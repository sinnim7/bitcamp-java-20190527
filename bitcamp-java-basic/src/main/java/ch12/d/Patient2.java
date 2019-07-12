package ch12.d;

public class Patient2 {
  
  public static final int WOMAN = 1;   ///상수 선언
  public static final int MAN = 2;
  
   
   public int age;
   public int weight;
   public int height;
   public int gender;
  public String name;
 
 
  
 
  public String getName() {
    
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public int getAge() {
   
    return age;
  }

  public void setAge(int age) {
    if (age >0 && age <150)
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }


  public void setWeight(int weight) {
    if (weight > 0 && weight <500)
    this.weight = weight;
  }


  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    if (height >0 && height < 300)
    this.height = height;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    if (gender > 0 && gender <3)
    this.gender = gender;
  }








  

  
  
  public String toString() { //this 생략함.
    return String.format("name=%s, age=%d, height=%d, weight=%d, gender=%d"
            , this.name, this.age, this.height, this.weight, this.gender);
  }
  
  
  

}
