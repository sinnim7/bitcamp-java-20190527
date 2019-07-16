package com.eomcs.util;

import java.util.Arrays;

public class ArrayList {
  
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
  
  
  public void add(Object obj) { 
    if (this.size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);  //비트이동.
      list = Arrays.copyOf(this.list, newCapacity);
  }
    this.list[this.size++] = obj;
  }
  
  public Object[] toArray() {
   
    return Arrays.copyOf(this.list, this.size);
  }
  
  
  
}
