package com.eomcs.util;

// 스택에 있는 데이터를 꺼내는 역할을 함.
// Iterator 규칙에 따라 작성해 
// 이 객체를 사용하는 개발자가 일관된 방식으로 호출할 수 있게 함.
public class StackIterator<E> implements Iterator<E> {

  Stack<E> stack;
  
  public StackIterator(Stack<E> stack) {
    this.stack = stack;
  }
  
  @Override
  public boolean hasNext() {
    
    return stack.size() > 0;
  }

  @Override
  public E next() {
    return stack.pop();
  }

}
