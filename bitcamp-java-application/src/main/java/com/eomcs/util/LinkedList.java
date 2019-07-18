package com.eomcs.util;

public class LinkedList {
  Node head;
  Node tail;
  int size = 0; //인스턴스필드 int는 초기화로 0임. 그래도 소스를 명확하게 하려고이렇게 함. 
  
  
  public LinkedList() {
    
    /*
     * head = new Node(); //노드 객체를 만들어 해드를 가리킴 tail = head;//헤드 값을 테일에 저장. 테일도 해드를 가리킴.
     * 
     * tail = head;
     */
  }
  public boolean add(Object value) {
    Node temp = new Node(value); //새 노드를 템프에 담음.
    if (head == null) //해드 값이 없을때만
      head = temp; //해드가 널이면 새로만든 템프에 저장.
    
    if (tail != null) //테일이 널이 아닐때만
      tail.next = temp; //테일이 가리키는 넥스트에 새 값을 담은 템프를 저장.
    
    tail = temp; //테일이라는 변수엔 새로 추가한 템프가 저장.
    //==> 마지막 테일은 주소가 null이됨.
    /*
    tail.value = value;  //테일이 가리키는 밸류에 value("aaa")를 저장.
    tail.next = new Node(); // 새 노드 만듦(밸류, 노드). 이 주소를 테일이 가리키는 넥스트에 저장.
    tail = tail.next; //테일이가리키는 넥스트변수값을 이자리에 두고 이걸 다시 테일이라는 변수에 저장.
    */
    size++;//사이즈 증가.
    return true;
  }

  
  public Object get(int index) { // 2번일때
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");

    Node node = head; //임시 노드를 만들고 여기에 해드 주소를 저장.
    for (int i = 0; i < index; i++) {  //현재 인덱스가 가리키는. 0일때는 이동할필요없음.
      // i가 0이면 인덱스 만큼 반복하는 걸로 생각. // 0부터 어떤것보다 작다는 건 어떤것만큼 반복하라는 얘기.
      
      node = node.next;  //노드가 가리키는 넥스트 주소를 (오른항에) 둔다. 이 주소를 노드에 저장.
    }
    return node.value; // 노드에 들어있는 값을 리턴함.
  }
  
 
  //특정 위치의 값을 바꾼다.
  public Object set(int index, Object value) {
    
    Node node = head;
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");

    
    for (int i = 0; i < index; i++) {
      node = node.next;  
    }
    
    Object oldVal = node.value;
    node.value = value;
    return oldVal;
  }
  
  
  
  // 특정 위치의 값을 삭제한다.
    public Object remove(int index) {
    if (index <0 || index >= size)
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다!");
    
    Node deletedNode = null;
    if (index == 0) {
      deletedNode = head;
      head = deletedNode.next;
    } else {
      
      Node node = head;
      for (int i = 0; i < index - 1; i++) {
        // 삭제하려는 노드의 이전 노드까지 간다.
        node = node.next;
      }
      // 이전 노드가 가리키는 다음 노드를 다음, 다음 노드를 가리키게 함.
      deletedNode = node.next; // 삭제될 노드를 임시 보관함.
      node.next = deletedNode.next; // 삭제될 노드의 다음 노드를 가리킴.
      
      if (deletedNode == tail) { //삭제할 노드가 마지막 노드라면
        tail = node; // tail 노드를 변경.
      }
    }
    
      Object oldVal = deletedNode.value; // 삭제돨 노드의 값을 임시 보관.
      deletedNode.value = null;   // 삭제될 노드가 다른 객체를 참조하지 않도록 값과 주소를 초기화시킴.
      deletedNode.next = null;    // 이런 식으로 개발자가 메모리 관리에 기여할 수 있음.
      size--;
      return oldVal;
    }
  
  
  
  public int size() {
    return size;
  }
  
  public void clear() {
    
    if (size == 0)
      return;
    
  //size가 0보다 클때 노드를 따라 가면서 삭제하기.
    
    head = tail = null; //테일을 먼저 널로 그리고 해드로.
    size = 0;
  }
  
  
  
  
}
