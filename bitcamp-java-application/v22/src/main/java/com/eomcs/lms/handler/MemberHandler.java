package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;
import com.eomcs.util.LinkedList;

public class MemberHandler {
  
  private LinkedList<Member> memberList = new LinkedList<>();
  private Input input;
  
  public MemberHandler(Input input) {
    this.input = input;
  }

  public void addMember() {
    Member member = new Member();
    member.setNo(input.getIntValue("번호? "));
    member.setName(input.getStringValue("이름? "));
    member.setEmail(input.getStringValue("이메일? "));
    member.setPassword(input.getStringValue("암호? "));
    member.setPhoto(input.getStringValue("사진? "));
    member.setTel(input.getStringValue("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member); 
    System.out.println("저장했습니다.");
  }

  public void listMember() {
    Member[] members = memberList.toArray(new Member[] {});
    
    memberList.toArray(members);
    for (Member member : members) {
      System.out.printf("%s, %s, %s, %s, %s\n", member.getNo(), member.getName(),
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
   
  }

  public void detailMember() {
    int no = input.getIntValue("번호? ");

    //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 레슨 객체가 찾음.
    Member member = null;
    
    for (int i = 0; i < memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break;
      }
    }
    
    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다.");
      return; //보이드 경우 그냥 리턴하면 함수를 끝내라는 얘기.
    }
    System.out.printf("이름 : %s\n", member.getName());
    System.out.printf("이메일 : %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진 : %s\n", member.getPhoto());
    System.out.printf("전화 : %s\n", member.getTel());
        
    
  }

  public void updateMember() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    
    for (int i = 0; i <memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break;
      }
    }
    
    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다");
      return;
    }
    
    //사용자로부터 변경할 값을 입력받는다.
    
    String str = input.getStringValue("이름(" + member.getName() + ")? ");
    String str1 = input.getStringValue("이메일(" + member.getEmail() + ")? ");
    String str2 = input.getStringValue("암호(" + member.getPassword() + ")? ");
    String str3 = input.getStringValue("사진(" + member.getPhoto() + ")? ");
    String str4 = input.getStringValue("전화(" + member.getTel() + ")? ");
    if (str.length() > 0) {
      member.setName(str);
      member.setEmail(str1);
      member.setPassword(str2);
      member.setPhoto(str3);
      member.setTel(str4);
    } 
    
   
    System.out.println("데이터를 변경했습니다.");
    
  }
  
  public void deleteMember() {
    int no = input.getIntValue("번호? ");
    
    //사용자가 입력한 번호를 가지고 목록에서 그 번호에 해당하는 Lesson 객체가 찾는다.
      for (int i = 0; i < memberList.size(); i++) {
        Member temp = memberList.get(i);
        if (temp.getNo() == no) {
          memberList.remove(i);
          System.out.println("데이터를 삭제했습니다.");
          return;
        }
      }
        System.out.println("해당 번호의 데이터가 없습니다.");
      }
  


}

