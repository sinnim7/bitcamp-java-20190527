package com.eomcs.lms.controller;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component("/auth/login")
public class LoginController implements PageController {
  private static final long serialVersionUID = 1L;
  
  @Resource
  private MemberDao memberDao;
  

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {
    
      HashMap<String,Object> params = new HashMap<>();
      params.put("email", request.getParameter("email"));
      params.put("password", request.getParameter("password"));
      
      Cookie cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15);
      response.addCookie(cookie);
      
      Member member = memberDao.findByEmailPassword(params);
      if (member == null) {
        throw new Exception("이메일 또는 암호가 맞지 않습니다!");
      } 
      
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", member);
      return "redirect:../board/list";
      
  }

}
