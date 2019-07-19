// 상속 문법을 이용해 스택 만들기

package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable, Iterable<E>{
  //스택 클래스는 링크드리스트를 확장하고 클로너블을 실행한다
  
  
  @Override
  public Stack<E> clone() throws CloneNotSupportedException{
    // 현재 스택 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행.
    // => 새 스택을 만들고,
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      // => 현재 스택에서 값을 꺼내 새 스택의 새 노드에 넣음.
      //    즉 새 스택은 값을 넣을 때마다 새 노드를 생성하기 때문에
      //    현재 스택의 노드에는 영향을 끼치지 않음.
      temp.push(get(i));
      
    }
    return temp;
    
  }
  
  public void push(E value) {
    add(value);
  }
 
  public E pop() {
    return remove(size() - 1);
  }
  
  
  
  public boolean empty() {
    return size() == 0;
  }
  
  
  //스택에서 Iterator를 제공함.
  @Override
  public Iterator<E> iterator() {
    
    //중첩 클래스를 정의한 후 인스턴스를 딱 한 개 생성하는 용도로 사용한다면
    //굳이 클래스 이름을 가질 필요가 없음.
    //클래스를 정의하자마자 바로 인스턴스를 만들어 사용하면 편함.
    //이렇게 정의하는 중첩 클래스를 "anonymous class"라 부름.
    
    return new Iterator<E>() {
      
      @Override
      public boolean hasNext() {
        return size() > 0;
      }
      
      @Override
      public E next() {
        return pop();
      }
    };
  }
}