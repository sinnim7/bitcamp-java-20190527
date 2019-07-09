package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Input;
//개별적으로 다뤄야 할 데이터를 다뤄야 한다면 인스턴스 필드로 만들어야.
//=> 개별인지 공유인지에 따라 각각 인스턴스, 스태틱을 선택하면 됨.
public class BoardHandler {  
  private Board[] boards = new Board[100];
  private int boardsSize = 0;

  public static Scanner keyScan; //굳이 인스턴스필드로 할 이유가 없음. 공유할 것이기 때문.


  public void addBoard() { //인슨터스 필드를 다루는 메서드는 인스턴스 메서드여야만 함. //스태틱 삭제.
    Board board = new Board();
    board.no = Input.getIntValue("번호? ");
    board.contents = Input.getStringValue("내용? ");
    board.createdDate = new Date(System.currentTimeMillis());

    boards[boardsSize++] = board;
    System.out.println("저장했습니다.");
  }

  public void listBoard() {
    for (int i = 0; i < boardsSize; i++) {
      Board board = boards[i];
      System.out.printf("%s, %s, %s, %s\n", board.no, board.contents, board.createdDate,
          board.viewCount);
    }
  }

  

}
