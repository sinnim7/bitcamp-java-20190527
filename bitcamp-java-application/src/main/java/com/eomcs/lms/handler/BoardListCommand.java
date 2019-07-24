package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;
//개별적으로 다뤄야 할 데이터를 다뤄야 한다면 인스턴스 필드로 만들어야.
//=> 개별인지 공유인지에 따라 각각 인스턴스, 스태틱을 선택하면 됨.
public class BoardListCommand implements Command{  
  
  private List<Board> list;

  private Input input;

 
  public BoardListCommand(Input input, List<Board> list) {
    this.input = input;
    this.list = list;
  }

  

  public void execute() {
    Board[] boards = list.toArray(new Board[] {}); 
    
    list.toArray(boards);
    for (Board board : boards) {
    System.out.printf("%s, %s, %s, %s\n", board.getNo(), 
        board.getContents(), board.getCreatedDate(), board.getViewCount());
    }
    
  }


}
