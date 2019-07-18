package algorithm.data_structure.linkedlist2.step2.step2;

public class LinkedListTest {
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("aaa");//aaa가 저장된 스트링 주소가 넘어감.
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");
    list.add("ggg");
    
    
    list.set(2, "xxx"); // "ccc" -> "xxx"로 변경
    
    list.remove(3); //"ddd" 삭제
    list.remove(0); //"aaa" 삭제
    list.remove(4); // "ggg" 삭제
    list.remove(0); // "bbb" 삭제
    list.remove(0); // "xxx" 삭제
    list.remove(0); // "eee" 삭제
    list.remove(0); // "fff" 삭제
    
    list.add("okok");
    list.add("nono");
    list.add("hul");
    
    //list.clear();
    
    Object[] arr = list.toArray();
    for (Object obj : arr) {
      System.out.println(obj);
      }
    
    /*
     * for (int i = 0; i < list.size(); i++) { 
     * Object value = list.get(i);
     * System.out.println(value); }
     */
  }
  
  
  
}
