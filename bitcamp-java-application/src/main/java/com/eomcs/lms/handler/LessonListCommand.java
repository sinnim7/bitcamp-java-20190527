package com.eomcs.lms.handler;


import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Input;

public class LessonListCommand implements Command{

  private List<Lesson> list;

  private Input input;   // 퍼블에서 프라이빗으로 바꿈

  public LessonListCommand(Input input, List<Lesson> list) {
    this.input = input;
    this.list = list;
  }

  public void execute() {
    Lesson[] lessons = list.toArray(new Lesson[] {});

    list.toArray(lessons);

    for (Lesson lesson : lessons) {
      System.out.printf("%s, %s, %s ~ %s, %s\n", lesson.getNo(), lesson.getTitle(), lesson.getStartDate(),
          lesson.getEndDate(), lesson.getTotalHours(), lesson.getDayHours());
    }



  }

}



