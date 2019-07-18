package com.eomcs.util;

public class Node {
  Object value; //값
  Node next; //주소
  
  public Node() { // 이미 생성자가 있어서 기본 생성자를 직접 만듦.
  }
  
  public Node(Object value) {
    this.value = value;
  }

}
