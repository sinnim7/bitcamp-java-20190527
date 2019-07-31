//v1 : 옵저버 등록 전  - 기능 기능만 사용
package design_pattern.observer.after;

public class Test03 {

  public static void main(String[] args) {
    Car car = new Car();
    
    
    //
    car.addObserver(new SafeBeltCarObserver());
    
    car.addObserver(new EngineOilCarObserver());
    car.start();
    
    car.run();
    
    car.stop();
    
    
  }
    
}








