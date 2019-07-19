package com.eomcs.util;

//목록을 다루는 객체가 반드시 갖춰야 할 기능을 규칙으로 정의.
//사용자들은 이 규칙에 따라 일관된 방식으로 클래스를 사용할 수 있음.
public interface List<E> {
  // 기능을 정의할 땐 메서드 시그너처만 선언.
  // 기능의 구현은 클래스에서 할 것.
  // (복습)제네릭은 맨 마지막 구현.
  // => 규칙은 무조건 공개돼야 함. 따라서 public임.
  // => 규칙에 정의된 메서드는 클래스에서 구현해야 함. 그래서 abstract임.
  // => public, abstract modifier는 생략 가능. 둘 중 하나만 써도 됨.
  
  /*public abstract */ boolean add(E value);
  /*public abstract */ E get(int index);
  /*public abstract */ E set(int index, E value);
  /*public abstract */E remove(int index); 
  /*public abstract */Object[] toArray();
  /*public abstract */E[] toArray(E[] a);//E의 배열을 받는 메서드.
  /*public abstract */ int size();
  /*public abstract */ void clear();
}
