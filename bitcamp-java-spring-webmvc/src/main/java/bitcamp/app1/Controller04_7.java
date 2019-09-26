// 요청 핸들러의 아규먼트 - @Cookie
package bitcamp.app1;

import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_7")
public class Controller04_7 {

  // 클라이언트가 보낸 쿠키 꺼내기
  // => @CookieValue(쿠키명) 애노테이션을 request handler의 아규먼트 앞에 붙인다.
  
  // 테스트:
  //    http://.../c04_7/h1
  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      HttpServletResponse response
      ) {
    // 이 메서드에서 쿠키를 클라이언트로 보낸다.
    try {
      // 쿠키의 값이 ASCII가 아니라면 URL 인코딩 해야만 데이터가 깨지지 않는다.
      // URL 인코딩을 하지 않으면 ? 문자로 변환된다.
      response.addCookie(new Cookie("name1", "홍길동"));
      response.addCookie(new Cookie(
              "name2", 
              URLEncoder.encode("홍길동", "UTF-8")
      ));
      response.addCookie(new Cookie("name3", "HongKildong"));
      response.addCookie(new Cookie("age", "20"));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    out.println("send cookie2!");
  }
  
  // 테스트:
  //    http://.../c04_7/h2
  @GetMapping(value="h2", produces = "text/plain;charset=UTF-8") 
  @ResponseBody 
  public String handler2(
      @CookieValue(value="name1", required=false) String name1,
      @CookieValue(value="name2", defaultValue="") String name2,
      @CookieValue(value="name3", defaultValue="") String name3,
      @CookieValue(value="age", defaultValue="0") int age  // String ===> int 자동 변환
      ) throws Exception {
    
    // 1) "AB가각"을 쿠키로 클라이언트로 보내기
    // "AB가각" 
    //      ==> (UTF-8 바이트) 41 42 ea b0 80 ea b0 81
    //       ==> (URL 인코딩) "AB%EA%B0%80%EA%B0%81"
    //           ==> 웹 브라우저에 저장
    
    
    //  2) 쿠키를 다시 서버로 보내기
    // - 문제는 DispatcherServlet이 이 쿠키 값을 String으로 바꿀 때 발생.
    // 
    //  "AB%EA%B0%80%EA%B0%81" (클라이언트로부터 받은 쿠기 값)
    //          ==> (프론트 컨트롤러가 URL 디코딩) 41 42 ea b0 80 ea b0 81
    //              ==> (바이트 배열을 UTF-16) 0041 0042 00ea 00b0 0080 00ea 00b0 0081
    //   디코딩된 바이트 배열이 ISO-8859-1이라고 간주하는 바람에
    //   잘못된 UTF-16 문자열로 바뀐 것.
    //
    //  해결책:
    // ==> UTF-16을 ISO-8859-1 로 변경
    // ==> 즉 원래의 바이트 배열로 바꾼다. 
    //     그러면 앞 1바이트를 제거한다.
    //     UTF-16을 ISO-8859-1로 바꾸라고 하면 각 2바이트 중 앞의 1바이트를 제거한 후 
    //     바이트 배열을 만든다.
    // => 다음 코드를 실행한 결과 : 41 42 ea b0 80 ea b0 81
    
    byte[] originBytes = name2.getBytes("ISO-8859-1"); 
    
    // => 다시 바이트 배열을 UTF-16으로 바꾼다.
    //    이때 바이트 배열이 UTF-8로 인코딩된 값이라는 걸 알려줘야 함.
    String namex = new String(originBytes, "UTF-8");
    
    return String.format("name1 = %s\n"
        + "name2 = %s\n"
        + "name3 = %s\n"
        + "age = %d\n",
        name1,
        namex,
        name3,
        age
        );
  }
  

}










