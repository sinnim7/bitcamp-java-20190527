package com.eomcs.util;

public class StaticTest2 {

  public static void main(String[] args) {
    
        Stack1<String> stack1 = new Stack1<>();
        stack1.push("aaa");
        stack1.push("bbb");
        stack1.push("ccc");
        stack1.push("ddd");
        stack1.push("eee");
        
        while (!stack1.empty()) {
          System.out.println(stack1.pop());
        }
        
  }

}
