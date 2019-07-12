package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Input;
//개별적으로 다뤄야 할 데이터를 다뤄야 한다면 인스턴스 필드로 만들어야.
//=> 개별인지 공유인지에 따라 각각 인스턴스, 스태틱을 선택하면 됨.
public class BoardHandler {  
  private Board[] boards = new Board[100];
  private int boardsSize = 0;

  private Input input;

   //BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // ==> Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //     "의존 객체(dependency)"라 부름.
  // ==> 의존 객체를 강제로 설정하게 만드는 방법?
  //     의존 객체를 넘겨 받는 생성자를 정의하는 것.
  //에러를 줄이기 위해 안정망을 갖추는 셈. 단점은 코드가 길어짐.
 
  public BoardHandler(Input input) {
    this.input = input;
  }

  
  public void addBoard() { //인슨터스 필드를 다루는 메서드는 인스턴스 메서드여야만 함. //스태틱 삭제.
    Board board = new Board();
    board.setNo(input.getIntValue("번호? "));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis()));

    boards[boardsSize++] = board;
    System.out.println("저장했습니다.");
  }

  public void listBoard() {
    for (int i = 0; i < boardsSize; i++) {
      Board board = boards[i];
      System.out.printf("%s, %s, %s, %s\n", board.getNo(), board.getContents(), board.getCreatedDate(),
          board.getViewCount());
    }
  }

  

}
