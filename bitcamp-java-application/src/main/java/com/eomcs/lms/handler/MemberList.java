package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {
  private Member[] list; //확장 대비해서 
  private int Size = 0;
  
  private static final int DEFAULT_Capacity = 100;
  
   MemberList() {
    this(DEFAULT_Capacity);
  }
  
  
  public MemberList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity> 10000)
      list = new Member[DEFAULT_Capacity];
    else
    list = new Member[initialCapacity];
  }
  
  
  public void add(Member Member) {
    this.list[this.Size++] = Member;
  }
  
  public Member[] toArray() {
    Member[] arr = new Member[this.Size];
    for (int i = 0; i < this.Size; i++) {
      arr[i] = this.list[i]; 
    }
    return arr;
  }
  
  
  
}
