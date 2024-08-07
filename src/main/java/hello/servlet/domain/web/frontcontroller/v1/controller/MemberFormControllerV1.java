package hello.servlet.domain.web.frontcontroller.v1.controller;

import hello.servlet.domain.web.frontcontroller.v1.Controllerv1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements Controllerv1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }
}