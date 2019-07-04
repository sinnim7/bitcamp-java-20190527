package com.eomcs.lms;

import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    
    java.io.InputStream keyboard = System.in;
    Scanner sc = new Scanner(keyboard);
    
    System.out.print("번호? ");
    String no = sc.nextLine();
    
    System.out.print("이름? ");
    String name = sc.nextLine();
    
    System.out.print("이메일? ");
    String email = sc.nextLine();
    
    System.out.print("암호? ");
    String password = sc.nextLine();
    
    System.out.print("사진? ");
    String photo = sc.nextLine();
    
    System.out.print("전화? ");
    String phoneNum = sc.nextLine();
        
    System.out.println();
    
    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("암호: " + password);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + phoneNum);
    System.out.println("가입일: 2019-01-01");
    
    /*
        번호: 1
        이름: 홍길동
        이메일: hong@test.com
        암호: 1111
        사진: hong.png
        전화: 1111-2222
        가입일: 2019-01-01
    */
    
    
    
  }

}
