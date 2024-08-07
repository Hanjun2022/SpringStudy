package hello.servlet.domain.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet",urlPatterns ="/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    //RequestDispatcher는 컨트롤러에서 모델로 이동할때 쓰인다. 서블릿 jsp 호출이가능하다. 여기서는 dispatcher가 컨트롤러가 뷰를 호출한다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
