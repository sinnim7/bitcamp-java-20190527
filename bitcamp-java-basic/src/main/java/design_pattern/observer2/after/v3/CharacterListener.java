package design_pattern.observer2.after.v3;

// 옵저버에게 한 문자를 읽을 때마다 알려주기 위해
// 메서드를 호출할 때 메서드의 규칙을 정의.
public interface CharacterListener {
  void readed(int ch);
  void displayResult();
  
}
