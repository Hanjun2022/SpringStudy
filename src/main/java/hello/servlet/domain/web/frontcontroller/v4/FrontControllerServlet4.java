package hello.servlet.domain.web.frontcontroller.v4;


import hello.servlet.domain.web.frontcontroller.MyView;
import hello.servlet.domain.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.domain.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.domain.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV4",urlPatterns = "/front-controller/v4/*")
public class FrontControllerServlet4 extends HttpServlet {
    private Map<String, ControllerV4> controllerv1Map=new HashMap<>();;

    public FrontControllerServlet4() {
        controllerv1Map.put("/front-controller/v4/members/new-form",new MemberFormControllerV4());
        controllerv1Map.put("/front-controller/v4/members/save",new MemberSaveControllerV4());
        controllerv1Map.put("/front-controller/v4/members",new MemberListControllerV4());
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServlet3.service");

        String requestUrl = request.getRequestURI();
        //객체 인스턴스가 반환이 된다.
        ControllerV4 controller = controllerv1Map.get(requestUrl);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParam(request);
        Map<String, Object> model = new HashMap<>();

        String viewpath = controller.process(paramMap, model);
        MyView view = viewResolver(viewpath);
        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName){
        return new MyView("/WEB-INF/views/"+viewName+".jsp");
    }

        private Map<String, String> createParam (HttpServletRequest request){
            Map<String, String> paramMap2 = new HashMap<>();
            request.getParameterNames().asIterator().forEachRemaining(paraname -> paramMap2.put(paraname,
                    request.getParameter(paraname)
            ));
            return paramMap2;

        }


    }















//        Map<String, String> paramMap = createParamMap(request);
//        Map<String,Object>model=new HashMap<>(); //요부분이 추가가 되었다.
//        String viewName= controller.process(paramMap,model);
//
//        //논리를 물리 롤 바꿈
//        MyView view=viewResolver(viewName);
//
//        view.render(model,request,response);
//
//    }
//    private Map<String,String>createParamMap(HttpServletRequest request){
//        Map<String,String>paramMap=new HashMap<>();
//        request.getParameterNames().asIterator().forEachRemaining(paraName
//                ->paramMap.put(paraName,request.getParameter(paraName)));
//        return paramMap;
//    }
//    private MyView viewResolver(String viewName){
//        return new MyView("/WEB-INF/views/"+viewName+".jsp");
//    }
//}

