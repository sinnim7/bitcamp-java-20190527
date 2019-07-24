package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;

public class MemberUpdateCommand implements Command{

  private List<Member> list;
  private Input input;

  public MemberUpdateCommand(Input input, List<Member> list) {
    this.input = input;
    this.list = list;
  }

  public void execute() {
    int no = input.getIntValue("번호? ");

    Member member = null;

    for (int i = 0; i <list.size(); i++) {
      Member temp = list.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break;
      }
    }

    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다");
      return;
    }

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



}

