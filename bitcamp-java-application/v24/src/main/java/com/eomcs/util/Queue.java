// 상속 문법을 이용해 큐 만들기

package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable, Iterable<E>{


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

  @Override
  public Iterator<E> iterator() {
    // => 중첩 클래스의 가장 큰 효용성은 다른 멤버(메서드)들처럼 다른 멤버를 그냥 사용할 수 있다는 것.
    return new Iterator<E>() {
      
      @Override
      public boolean hasNext() {
        return size() > 0;
      }
      
      @Override
      public E next() {
        return poll();
      }
    };
  }
}

  // => 이 클래스에서 사용할 클래스는 이 클래스 안에 선언하는 게 소스 코드 관리에 좋음.
  //    이렇게 클래스 안에 선언된 클래스를 nested class(중첩 클래스)라 부름.
  //    중첩 클래스 중 static이 붙지 않은 중첩 클래스를 "non-static nested class"라 부름.
  //    non-static nested class를 "inner class"라 부름.

  
  
