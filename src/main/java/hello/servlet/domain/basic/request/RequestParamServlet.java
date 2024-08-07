package hello.servlet.domain.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 *
 * 1.파라미터 전송 기능
 * http:/localhost:8080/requst-param?username=hello&age=20
 * 여기로 들어가야 조회가 된다.
 * // request.getParameter(paramName=키값)
 */
@WebServlet(name="requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");
        System.out.println(" [전체 파라미터 조회 ] -start");
        //요즘 스타일이다. 암기좀 하자 지금 여기서 key 및 value를 꺼낸다.
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName-> System.out.println(paramName+ " = "+  request.getParameter(paramName)));
        System.out.println(" [전체 파라미터 조회 ] - end ");
        System.out.println();

        //단일 파라미터는 getParameter를 가장 많이 사용한다.
        System.out.println(" [단일 파라미터 조회 ]");
        String username=request.getParameter("username");
        String age=request.getParameter("age");

        System.out.println("username = " +username);
        System.out.printf("age = "+ age);

        //조회 키가 여러가지 인경우 getParameterValues() 로 조회해서 가져가자
        String[]arr=request.getParameterValues("username");
        for(String name:arr){
            System.out.println("user name = " +name);
        }

        //화면에 무엇을 써주기
        response.getWriter().write("OK");
        Enumeration<String>parameterNames=request.getParameterNames();
        return;
    }

}
