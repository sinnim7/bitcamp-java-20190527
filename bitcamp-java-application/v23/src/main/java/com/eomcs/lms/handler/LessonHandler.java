package com.eomcs.lms.handler;


import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Input;
import com.eomcs.util.LinkedList;
import com.eomcs.util.List;

public class LessonHandler {
 
  private List<Lesson> lessonList;
  
  private Input input;   // 퍼블에서 프라이빗으로 바꿈
  
  public LessonHandler(Input input, List<Lesson> list) {
    this.input = input;
    this.lessonList = list;
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

  public void detailLesson() {
    int no = input.getIntValue("번호? ");
    
    //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체가 찾는다.
    Lesson lesson = null; //0도 있으니까 아예 널로 초기화.
    
    for (int i = 0; i < lessonList.size(); i++) {
      Lesson temp = lessonList.get(i);
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

  public void updateLesson() {
    int no = input.getIntValue("번호? ");
    
  //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체가 찾는다.
    Lesson lesson = null;
    
    for (int i = 0; i < lessonList.size(); i++) {
      Lesson temp = lessonList.get(i);
      if (temp.getNo() == no) {
        lesson = temp;
        break;
      }
    }
    
    if (lesson == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; //void 경우 그냥 리턴하면 함수를 끝내라는 얘기.
    }
   
    
    //사용자로부터 변경할 값을 입력 받는다.
    String str = input.getStringValue("수업명(" + lesson.getTitle() + ")? ");
    if (str.length() > 0) {
      lesson.setTitle(str);
    } 
    
    str = input.getStringValue("수업내용? ");
    if (str.length() > 0) {
      lesson.setContents(str);
    }
    
    lesson.setStartDate(input.getDateValue("시작일(" + lesson.getStartDate() + ")? "));

    lesson.setEndDate(input.getDateValue("종료일(" + lesson.getEndDate() + ")? "));
    
    lesson.setTotalHours(input.getIntValue("총수업시간(" + lesson.getTotalHours() + ")? "));
    
    lesson.setDayHours(input.getIntValue("총수업시간(" + lesson.getDayHours() + ")? "));
    
    System.out.println("데이터를 변경했습니다.");
    
  }

  public void deleteLesson() {
    int no = input.getIntValue("번호? ");
    
    //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체가 찾는다.
      for (int i = 0; i < lessonList.size(); i++) {
        Lesson temp = lessonList.get(i);
        if (temp.getNo() == no) {
          lessonList.remove(i);
          System.out.println("데이터를 삭제했습니다.");
          return;
        }
      }
        System.out.println("해당 번호의 데이터가 없습니다.");
      }
      
      
      
      
      
      
  }
  
  

