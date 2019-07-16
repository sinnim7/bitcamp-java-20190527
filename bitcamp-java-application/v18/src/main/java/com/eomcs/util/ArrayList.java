package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> { // <E> : element, <T>:dataType
  
  private static final int DEFAULT_Capacity = 100;
  
  private Object[] list; //확장 대비해서 
  private int size = 0;
  
  public ArrayList() {   //편의성 제공 : 기본 셋팅은 100개.
    this(DEFAULT_Capacity); //특수문법. 다른 생성자를 가리킬 때 사용됨.
               //생성자만 다른 생성자를 호출할 수 있음.
    //생성자에서 다른 생성자를 호출 할 수 있음.
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity> 10000)
      list = new Object[DEFAULT_Capacity];
    else
      list = new Object[initialCapacity];
  }
  
  
  public void add(E obj) { 
    if (this.size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);  //비트이동.
      list = Arrays.copyOf(this.list, newCapacity);
  }
    this.list[this.size++] = obj;
  }
  
  public Object[] toArray() {
   
    return Arrays.copyOf(this.list, this.size); // new Object(this.size); 
  }
  
  public E[] toArray(E[] a) {
    //java.util.ArrayList l;  소스보기
    if (a.length < size) {
      // 파라미터로 넘겨 받은 배열의 크기가 저장된 데이터의 개수보다 작다면
      // 이 메서드에서 새 배열을 만든다.
      //return(E[]) Arrays.copyOf(list, size, a.getClass()); // 세 번째 파라미터로 지정한 타입의 배열이 생성됨.
      
      return(E[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size) //넘겨받은값이 현재배열값보다클때 값 채운 다음방에 널을 리턴.
      a[size] = null;    //복사한 그 다음 방.
    
    
    
    return a;
  }
    
  public int size() {
    return this.size;
  }
  
  
  
  
  
  
}
