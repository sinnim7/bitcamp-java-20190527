package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
  
  private static final int DEFAULT_Capacity = 100;
  
  private Lesson[] list; //확장 대비해서 
  private int Size = 0;
  
  
  public LessonList() {
    this(DEFAULT_Capacity);
  }
  
  private LessonList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity >10000)
      list = new Lesson[DEFAULT_Capacity];
   else
    list = new Lesson[initialCapacity];
  }
  
  
  public void add(Lesson lesson) {
    if (this.Size == list.length)
      throw new RuntimeException("배열이 꽉 찼습니다!");
    this.list[this.Size++] = lesson;
  }
  
  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[this.Size];
    for (int i = 0; i < this.Size; i++) {
      arr[i] = this.list[i]; 
    }
    return arr;
  }
  
  
  
}
