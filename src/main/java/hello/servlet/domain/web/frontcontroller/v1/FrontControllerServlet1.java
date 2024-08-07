package hello.servlet.domain.web.frontcontroller.v1;

import hello.servlet.domain.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.domain.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.domain.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// *이라고 하면 하위 코드는 다 들어온다.

@WebServlet(name="FrontControllerServlet1",urlPatterns = "/front-controller/v1/*")
public  class FrontControllerServlet1 extends  HttpServlet{

    private Map<String,Controllerv1>Controllv1Map=new HashMap<>();

    public FrontControllerServlet1(){
        Controllv1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        Controllv1Map.put("/front-controller/v1/members",new MemberListControllerV1());
        Controllv1Map.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestUrl=request.getRequestURI();
        Controllerv1 controllerv1=Controllv1Map.get(requestUrl);
        if(controllerv1==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controllerv1.process(request,response);

    }
}