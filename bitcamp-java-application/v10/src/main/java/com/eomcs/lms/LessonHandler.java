package com.eomcs.lms;


import java.util.Scanner;

public class LessonHandler {
  static Lesson[] lessons = new Lesson[100];
  static int lessonsSize = 0;
  
  static Scanner keyScan;
  
  static void addLesson() { // 메서드 이름은 동사 + 명사 형태로 만든다.
    // 수업 데이터를 저장할 메모리를 Lesson 설계도에 따라 만든다.
    Lesson lesson = new Lesson();
    // 사용자가 입력한 값을 Lesson 인스턴스의 각 변수에 저장.
    lesson.no = Input.getIntValue("번호? ");
    lesson.title = Input.getStringValue("수업명? ");
    lesson.contents = Input.getStringValue("설명? ");
    lesson.startDate = Input.getDateValue("시작일? ");
    lesson.endDate = Input.getDateValue("종료일? ");
    lesson.totalHours = Input.getIntValue("총수업시간? ");
    lesson.dayHours = Input.getIntValue("일수업시간? ");
    // 수업 데이터를 저장하고 있는 인스턴스의 주소를 레퍼런스 배열에 저장.
    lessons[lessonsSize++] = lesson; // 0번방부터 시작하는 셈.
    System.out.println("저장했습니다.");
  }

  static void listLesson() {
    for (int i = 0; i < lessonsSize; i++) {
      // 레퍼런스 배열에서 한 개의 인스턴스 주소를 꺼낸다.
      Lesson lesson = lessons[i];
      // 그 인스턴스 주소로 찾아가서 인스턴스의 각 변수 값을 꺼내 출력한다.
      System.out.printf("%s, %s, %s ~ %s, %s\n", lesson.no, lesson.title, lesson.startDate,
          lesson.endDate, lesson.totalHours, lesson.dayHours);
    }
  }
  
  
}
