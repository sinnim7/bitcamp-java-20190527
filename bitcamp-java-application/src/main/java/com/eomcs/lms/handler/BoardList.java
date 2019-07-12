package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  
  private static final int DEFAULT_Capacity = 100;
  
  private Board[] list; //확장 대비해서 
  private int Size = 0;
  
  public BoardList() {   //편의성 제공 : 기본 셋팅은 100개.
    this(DEFAULT_Capacity); //특수문법. 다른 생성자를 가리킬 때 사용됨.
               //생성자만 다른 생성자를 호출할 수 있음.
    //생성자에서 다른 생성자를 호출 할 수 있음.
  }
  
  public BoardList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity> 10000)
      list = new Board[DEFAULT_Capacity];
    else
    list = new Board[initialCapacity];
  }
  
  
  public void add(Board Board) {
    if (this.Size == list.length)
      throw new RuntimeException("배열이 꽉 찼습니다!");
    
    //this(100); //컴파일 오류! 일반 메서드는 생성자를 호출할 수 없음.
    this.list[this.Size++] = Board;
  }
  
  public Board[] toArray() {
    Board[] arr = new Board[this.Size];
    for (int i = 0; i < this.Size; i++) {
      arr[i] = this.list[i]; 
    }
    return arr;
  }
  
  
  
}
