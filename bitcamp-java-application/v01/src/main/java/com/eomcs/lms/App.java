//애플리케이션 메인 클래스
//=> 애플리케이션을 실행할 때 이 클래스를 실행함.

package com.eomcs.lms;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(App.getGreeting());
    }
}
