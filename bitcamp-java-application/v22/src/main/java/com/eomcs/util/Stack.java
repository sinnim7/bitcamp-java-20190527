// 상속 문법을 이용해 스택 만들기

package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable{
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
  /*
  public E pop() {
    return remove(size() - 1);
  }
 */
  
  public E pop() {
    return remove(size() - 1);
  }
  
  
  
  public boolean empty() {
    return size() == 0;
  }
  
  
}
