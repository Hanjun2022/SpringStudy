package hello.servlet.domain.web.frontcontroller.v2;

import hello.servlet.domain.web.frontcontroller.MyView;
import hello.servlet.domain.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.domain.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.domain.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// *이라고 하면 하위 코드는 다 들어온다.

@WebServlet(name="frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public  class FrontControllerServlet2 extends  HttpServlet{
    private Map<String,ControllerV2>controllerV2Map=new HashMap<>();

    public  FrontControllerServlet2(){
        controllerV2Map.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
        controllerV2Map.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v2/members",new MemberListControllerV2());
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestUrl=request.getRequestURI();
        ControllerV2 controllerV2=controllerV2Map.get(requestUrl);
        if(controllerV2==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }
        MyView myView=controllerV2.process(request,response);
        myView.render(request,response);
        return;
    }
}