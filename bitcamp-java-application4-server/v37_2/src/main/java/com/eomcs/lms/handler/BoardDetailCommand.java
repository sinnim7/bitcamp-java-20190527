package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Input;

public class BoardDetailCommand implements Command {
  
  private BoardDao boardDao;
  
  public BoardDetailCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public void execute(BufferedReader in, PrintStream out) {
    
    
    

    try {
      
      // 클라에게 번호를 요구해 받음.
      int no = Input.getIntValue(in, out, "번호? ");
      
      // 사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Board 객체를 찾는다.
      Board board = boardDao.findBy(no);
      
      if (board == null) {
        out.println("해당 번호의 데이터가 없습니다!");
        return;
      }
      
      out.printf("내용: %s\n", board.getContents());
      out.printf("작성일: %s\n", board.getCreatedDate());
      
    } catch (Exception e) {
      out.println("데이터 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }

}
