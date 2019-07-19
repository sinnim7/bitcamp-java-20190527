// 상속 문법을 이용해 큐 만들기

package com.eomcs.util.step1;

import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;

public class Queue<E> extends LinkedList<E> implements Cloneable{
  
  @Override
  public Queue<E> clone() throws CloneNotSupportedException{
    // 현재 큐 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행.
    // => 새 큐를 만들고,
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < size(); i++) {
      // => 현재 큐에서 값을 꺼내 새 큐의 새 노드에 넣음.
      //    즉 새 큐는 값을 넣을 때마다 새 노드를 생성하기 때문에
      //    현재 큐의 노드에는 영향을 끼치지 않음.
      temp.offer(get(i));
    }
    return temp;
  }
  
  public void offer(E value) {
    add(value);
  }
  
  public E poll() {
    return remove(0);
  }
  
  public boolean empty() {
    return size() == 0;
  }
  
  // 큐의 데이터를 꺼낼 Iterator를 제공.
  public Iterator<E> createrIterator() {
    return new QueueIterator<E>(this);
  }
  
  
  
  
  
  
}