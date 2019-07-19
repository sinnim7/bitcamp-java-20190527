package com.eomcs.util;

public class Stack1<E> extends LinkedList<E> {

  public void push(E value) {
    add(value);
  }

  public boolean empty() {
    return size() == 0;
    
  }

  public E pop() {
    return remove(size - 1);
  }

  
  
  
}
