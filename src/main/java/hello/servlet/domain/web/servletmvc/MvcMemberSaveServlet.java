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

@WebServlet(name="mvcMemeberSaveServlet",urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Form으로 받은 정보를 분리해서 분리한다.
        String username=request.getParameter("username");
        int age =Integer.parseInt(request.getParameter("age"));
        //member에 담고 레포지토리에 담는다.
        Member member=new Member(username,age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        request.setAttribute("member",member);

        String viewPath= "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
