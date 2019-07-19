package com.eomcs.util;


// Iterator를 제공하는 클래스를 갖춰야 할 메서드 규칙을 정의.
// Iterator가 필요한 개발자는 다음 규칙에 따라 메서드를 호출해
// Iterator를 얻음.
// 즉 Iterator를 얻는 방법도 일관성 있게 하기 위함.
// 이 방법을 도입하기 전에는
// Stack 클래스에선 getIterator() 메서드를 제공했고
// Queue 클래스에선 createIterrator() 메서드를 제공했음.
// 이렇게 Iterator를 리턴해 주는 메서드 이름이 다르면
// 소스 코드 유지보수기 불편.

public interface Iterable<E> {
  // 다음 메서드를 호출하면 Iterator 구현체를 리턴할 것.
  // Stack과 Queue는 이 규칙을 준수해야 함.
  // 그래야 개발자가 일관된 방식으로 Iterator를 얻을 수 있음.
  Iterator<E> iterator();
  

}
