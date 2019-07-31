//v1 : 옵저버 등록 전  - 기능 기능만 사용
package design_pattern.observer.after;

public class Test05 {

  public static void main(String[] args) {
    Car car = new Car();
    
    car.addObserver(new SafeBeltCarObserver());
    car.addObserver(new EngineOilCarObserver());
    car.addObserver(new BreakOilCarObserver());
    
    // 예) 4월 15일 - 자동차 시동을 끌 때 전조등 자동 끄기 기능을 추가
    car.addObserver(new LightOffCarObserver());

    
    car.start();
    
    car.run();
    
    car.stop();
    
    
  }
    
}








