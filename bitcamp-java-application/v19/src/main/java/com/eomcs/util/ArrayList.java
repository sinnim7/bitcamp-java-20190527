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
  
  @SuppressWarnings("unchecked") // E타입 관련 경고 띄우지말라는 것.
  //java.util.ArrayList k;
  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
      //예외발생시화면에띄움.
    return (E) list[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    
    E old = (E) list[index];
    list[index] = obj;
    
    return old;
  }
  
  
  public E remove(int index) {
    if (index < 0 || index >= size) //==> 유효한 위치인지 파악.
      throw new IndexOutOfBoundsException(String.format("인덱스 = %s", index));
    
    @SuppressWarnings("unchecked")
    E old = (E) list[index];
    
    //방법1 : 직접 반복문을 이용해 삭제 처리하기

    /*
    for (int i = index + 1; i < size; i++) {
      list[i-1] = list[i];
      
    }
    
    list[--size] =null; // 6(0~5), 5(0~4) 
    //=> 가비지로 안바뀐 거 처리.
   
    */
     
  
  //방법2 : 배열 복사 기능을 이용해 삭제 처리하기
    
     System.arraycopy(list, index + 1, list, index, size - (index + 1));
     
     //삭제한 후 기존 맨 끝값이 들어 있던 방을 null로 설정.
     // => 레퍼런스가 남아 있지 않게 해 가비지가 정상적으로 이뤄지게 함.
     list[--size] = null;
     
     return old;
    
    
  }
  
  
  
  public static void main(String[] args) {
    
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(-1);
    list1.add(5);
    System.out.println(list1.get(0));
    
    System.out.println(list1.get(1));
    
    
    ArrayList<String> list = new ArrayList<>();
    list.add("000");
    list.add("111");
    list.add("222");
    list.add("333");
    list.add("444");
    list.add("555");
    
    String old = list.remove(0);
    
    //String old = list.set(1, "안중근");
    System.out.println("원래값 : " + old);
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    
    
    
    
  }
  
  
}
