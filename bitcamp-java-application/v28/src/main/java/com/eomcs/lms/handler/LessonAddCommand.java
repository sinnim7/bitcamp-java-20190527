package com.eomcs.lms.handler;


import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Input;

public class LessonAddCommand implements Command{

  private List<Lesson> list;

  private Input input;  

  public LessonAddCommand(Input input, List<Lesson> list) {
    this.input = input;
    this.list = list;
  }

  public void execute() {
    Lesson lesson = new Lesson();
    lesson.setNo(input.getIntValue("번호? "));
    lesson.setTitle(input.getStringValue("수업명? "));
    lesson.setContents(input.getStringValue("설명? "));
    lesson.setStartDate(input.getDateValue("시작일? "));
    lesson.setEndDate(input.getDateValue("종료일? "));
    lesson.setTotalHours(input.getIntValue("총수업시간? "));
    lesson.setDayHours(input.getIntValue("일수업시간? "));

    list.add(lesson); 
    System.out.println("저장했습니다.");
  }


}



