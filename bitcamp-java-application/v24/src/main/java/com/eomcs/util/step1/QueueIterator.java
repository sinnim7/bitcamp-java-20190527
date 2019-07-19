package com.eomcs.util.step1;

import com.eomcs.util.Iterator;

// 큐에 있는 데이터를 꺼내는 역할을 함.
// Iterator 규칙에 따라 작성해 
// 이 객체를 사용하는 개발자가 일관된 방식으로 호출할 수 있게 함.
public class QueueIterator<E> implements Iterator<E> {

  Queue<E> queue;
  
  public QueueIterator(Queue<E> queue) {
    this.queue = queue;
  }
  
  @Override
  public boolean hasNext() {
    
    return queue.size() > 0;
  }

  @Override
  public E next() {
    return queue.poll();
  }

}
