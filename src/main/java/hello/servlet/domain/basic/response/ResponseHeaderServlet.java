package hello.servlet.domain.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet",urlPatterns ="/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //status line
        response.setStatus(HttpServletResponse.SC_OK);
       //response 상태코드를 넣을 수 있다.

        //[response-headers]
        response.setHeader("Content-Type","text.plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");

       // content(response);
        //cookie(response);


        PrintWriter writer=response.getWriter();
        writer.println("OK");
    }

    private void content(HttpServletResponse response){
        //위에 꺼를 이런 식으로 다시 표현이 가능하다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }


    private  void cookie(HttpServletResponse response){
        //쿠키 값을 설정하는 방법이다.
        Cookie cookie=new Cookie("myCookie","REALLY-GOOD");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response){

        // http 리다이렉트
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location","/basic/hello-form.html");
    }
}
