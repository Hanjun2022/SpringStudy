package hello.servlet.domain.web.servletmvc;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;


@WebServlet(name="mvcMemberListServlet",urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //memberRespoitory에 들어가 있는 모든 정보를 조회해서 가져오고 그 정보를
        List<Member> members =memberRepository.findAll();
        //request .setAttribute를 통해서 Model 에 담는다.
        request.setAttribute("members",members);

        String viewPath="/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}


