package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;
//개별적으로 다뤄야 할 데이터를 다뤄야 한다면 인스턴스 필드로 만들어야.
//=> 개별인지 공유인지에 따라 각각 인스턴스, 스태틱을 선택하면 됨.
public class BoardUpdateCommand implements Command{  
  
  private List<Board> list;

  private Input input;
  public BoardUpdateCommand(Input input, List<Board> list) {
    this.input = input;
    this.list = list;
  }


  public void execute() {
    int no = input.getIntValue("번호? ");
    
      Board board = null;
      
      for (int i = 0; i < list.size(); i++) {
        Board temp = list.get(i);
        if (temp.getNo() == no) {
          board = temp;
          break;
        }
      }
      
      if (board == null) {
        System.out.println("해당 번호의 데이터가 없습니다.");
        return; //void 경우 그냥 리턴하면 함수를 끝내라는 얘기.
      }
     
      String str = input.getStringValue("내용(" + board.getContents() + ")? ");
      if (str.length() > 0) {
        board.setContents(str);
      } 
      
      System.out.println("데이터를 변경했습니다.");
      
  }


}
