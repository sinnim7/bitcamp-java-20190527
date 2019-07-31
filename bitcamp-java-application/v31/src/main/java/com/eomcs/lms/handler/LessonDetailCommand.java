package com.eomcs.lms.handler;


import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Input;

public class LessonDetailCommand implements Command{
 
  private List<Lesson> list;
  
  private Input input;   
  
  public LessonDetailCommand(Input input, List<Lesson> list) {
    this.input = input;
    this.list = list;
  }
  
  public void execute() {
    int no = input.getIntValue("번호? ");
    
    Lesson lesson = null; 
    
    for (int i = 0; i < list.size(); i++) {
      Lesson temp = list.get(i);
      if (temp.getNo() == no) {
        lesson = temp;
        break;
      }
    }
    
    if (lesson == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; //void 경우 그냥 리턴하면 함수를 끝내라는 얘기.
    }
    
    System.out.printf("수업명 : %s\n", lesson.getTitle());
    System.out.printf("수업내용 : %s\n", lesson.getContents());
    System.out.printf("기간 : %s\n", lesson.getStartDate());
    System.out.printf("총수업시간 : %s\n", lesson.getEndDate());
    System.out.printf("일수업시간 : %s\n", lesson.getDayHours());
    
  }

  }
  
  

