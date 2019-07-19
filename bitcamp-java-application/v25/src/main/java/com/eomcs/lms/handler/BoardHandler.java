package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;
//개별적으로 다뤄야 할 데이터를 다뤄야 한다면 인스턴스 필드로 만들어야.
//=> 개별인지 공유인지에 따라 각각 인스턴스, 스태틱을 선택하면 됨.
public class BoardHandler {  
  
  private List<Board> boardList;

  private Input input;

   //BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // ==> Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //     "의존 객체(dependency)"라 부름.
  // ==> 의존 객체를 강제로 설정하게 만드는 방법?
  //     의존 객체를 넘겨 받는 생성자를 정의하는 것.
  //에러를 줄이기 위해 안정망을 갖추는 셈. 단점은 코드가 길어짐.
 
  public BoardHandler(Input input, List<Board> list) {
    this.input = input;
    this.boardList = list;
  }

  
  public void addBoard() { //인슨터스 필드를 다루는 메서드는 인스턴스 메서드여야만 함. //스태틱 삭제.
    Board board = new Board();
    board.setNo(input.getIntValue("번호? "));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis()));

    boardList.add(board); 
    System.out.println("저장했습니다."); 
  }

  public void listBoard() {
    //Board[] boards = new Board[boardList.size()];
    //boardList.toArray(boards);
    Board[] boards = boardList.toArray(new Board[] {}); //작은 배열을 주고 그걸 복사하게 할 것인가?
    
    boardList.toArray(boards);
    for (Board board : boards) {
    System.out.printf("%s, %s, %s, %s\n", board.getNo(), 
        board.getContents(), board.getCreatedDate(), board.getViewCount());
    }
    
  }


  public void detailBoard() {
    int no = input.getIntValue("번호? ");
    
    //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체가 찾는다.
    Board board = null; //0도 있으니까 아예 널로 초기화.
    
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        break;
      }
    }
    
    
    if (board == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; //void 경우 그냥 리턴하면 함수를 끝내라는 얘기.
    }
    
    System.out.printf("번호 : %s\n", board.getContents());
    
  }


  public void updateBoard() {
    int no = input.getIntValue("번호? ");
    
      Board board = null;
      
      for (int i = 0; i < boardList.size(); i++) {
        Board temp = boardList.get(i);
        if (temp.getNo() == no) {
          board = temp;
          break;
        }
      }
      
      if (board == null) {
        System.out.println("해당 번호의 데이터가 없습니다.");
        return; //void 경우 그냥 리턴하면 함수를 끝내라는 얘기.
      }
     
      
      //사용자로부터 변경할 값을 입력 받는다.
      String str = input.getStringValue("내용(" + board.getContents() + ")? ");
      if (str.length() > 0) {
        board.setContents(str);
      } 
      
     
      System.out.println("데이터를 변경했습니다.");
      
  }


  public void deleteBoard() {
int no = input.getIntValue("번호? ");
    
    //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체가 찾는다.
      for (int i = 0; i <boardList.size(); i++) {
        Board temp = boardList.get(i);
        if (temp.getNo() == no) {
          boardList.remove(i);
          System.out.println("데이터를 삭제했습니다.");
          return;
        }
      }
        System.out.println("해당 번호의 데이터가 없습니다.");
      }
  

  

}
