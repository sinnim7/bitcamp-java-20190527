package com.eomcs.lms.context;

import java.util.Map;

// 애플리케이션의 상태에 따라 보고를 받는 클래스가 갖춰야 할 메서드 규칙
// 애플리케이션은 다음 인터페이스에 정의된 규칙대로 옵저버의 메서드를 호출할 것.

public interface ApplicationContextListener {

    // 애플리에션을 시작하는 즉시 옵저버의 메서드를 호출
    default void contextInitialized(Map<String, Object> beanContainer) {}
    
    // 애플리케이션이 종료되기 직전에 이 옵저버의 메서드를 호출
    default void contextDestroyed(Map<String, Object> beanContainer) {}
}
