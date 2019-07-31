package design_pattern.observer2.after.v4;

public class LineCommentListener implements CharacterListener{

  int lines = 0;
  boolean startLines = false;
  int countSlash = 0;


  @Override
  public void readed(int ch) {
    if (!startLines) {

      if (ch == '/') {
        if (countSlash == 0) {
          countSlash++;
        } else {
          lines++;
          startLines = true;
        } 
      } else {
        countSlash = 0;
      }
    }else if (ch == '\n'){
      startLines = false;
    }


  }
  @Override
  public void displayResult() {
    System.out.printf("한 줄 주석 개수 : %d\n", lines);
  }


}
