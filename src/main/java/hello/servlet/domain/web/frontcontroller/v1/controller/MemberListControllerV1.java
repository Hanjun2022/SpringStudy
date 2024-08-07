package hello.servlet.domain.web.frontcontroller.v1.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.domain.web.frontcontroller.v1.Controllerv1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements Controllerv1 {
    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Member> members =memberRepository.findAll();
//        request.setAttribute("members",members);
//
//        String viewPath="/WEB-INF/views/members.jsp";
//        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request,response);

        List<Member>members=memberRepository.findAll();
        request.setAttribute("members",members);

        String viewPath="/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
