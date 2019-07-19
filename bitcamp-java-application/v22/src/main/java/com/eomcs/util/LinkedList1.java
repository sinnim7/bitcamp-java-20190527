package com.eomcs.util;

public class LinkedList1<T> {
  
  Node<T> head;
  Node<T> tail;
  int size = 0;
  

public boolean add(T value) {
  Node<T> temp = new Node<>(value);
  if (head == null)
    head = temp;
  if (tail !=null)
    tail.next = temp;
  tail = temp;
  size++;
  return true;
}

public T set(int index, T value) {
  
  Node<T> node = head;
  if (index < 0 || index >= size)
    throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다");
  
  Node<>
    
  
  
}



static public class Node<T> {
  T value;
  Node<T> next;
  
  public Node() {
    
  }
  
  public Node(T value) {
    this.value = value;
  }
  
  
  
  
}
