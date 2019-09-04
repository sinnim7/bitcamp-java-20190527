package ch29.f;

import org.springframework.beans.factory.FactoryBean;

public class BlackBoxFactoryBean implements FactoryBean<BlackBox> {
  
  String maker;
  String model;
  
  
  public BlackBoxFactoryBean(String maker, String model) {
    this.maker = maker;
    this.model = model;
  
    System.out.println("BlackBoxFactoryBean(String, String)");
  }
  
  @Override
  public Class<?> getObjectType() {
    return BlackBox.class;
  }
  
  @Override
  public BlackBox getObject() throws Exception { // 생성자에서 받은 파라미터 값을 가지고 블랙박스를 만들어 리턴.
    System.out.println("BlackBoxFactoryBean.getObject()");
    BlackBox obj = new BlackBox();
    obj.setMaker(this.maker);
    obj.setModel(this.model);
    return obj;
  }

}
