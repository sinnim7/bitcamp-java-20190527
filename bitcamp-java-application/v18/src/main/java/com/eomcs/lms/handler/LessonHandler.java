package com.eomcs.lms.handler;


import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Input;

public class LessonHandler {
 
  private ArrayList<Lesson> lessonList = new ArrayList();
  
  private Input input;   // 퍼블에서 프라이빗으로 바꿈
  
  public LessonHandler(Input input) {
    this.input = input;
  }
  
  public void addLesson() {
    Lesson lesson = new Lesson();
    lesson.setNo(input.getIntValue("번호? "));
    lesson.setTitle(input.getStringValue("수업명? "));
    lesson.setContents(input.getStringValue("설명? "));
    lesson.setStartDate(input.getDateValue("시작일? "));
    lesson.setEndDate(input.getDateValue("종료일? "));
    lesson.setTotalHours(input.getIntValue("총수업시간? "));
    lesson.setDayHours(input.getIntValue("일수업시간? "));
    

    //LessonsHandler에서 직접 데이터를 보관하지 않고
    //LessonsList에게 전달.
    lessonList.add(lesson); 
    System.out.println("저장했습니다.");
  }

  public void listLesson() {
    Lesson[] lessons = lessonList.toArray(new Lesson[] {});
    
    lessonList.toArray(lessons);
    
    
    
    for (Lesson lesson : lessons) {
      System.out.printf("%s, %s, %s ~ %s, %s\n", lesson.getNo(), lesson.getTitle(), lesson.getStartDate(),
          lesson.getEndDate(), lesson.getTotalHours(), lesson.getDayHours());
    }
    
   
  
  }
}
