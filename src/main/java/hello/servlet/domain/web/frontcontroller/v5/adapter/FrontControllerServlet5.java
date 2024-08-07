package hello.servlet.domain.web.frontcontroller.v5.adapter;

import hello.servlet.domain.web.frontcontroller.ModelView;
import hello.servlet.domain.web.frontcontroller.MyView;
import hello.servlet.domain.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.domain.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.domain.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.domain.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.domain.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.domain.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet.domain.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@WebServlet(name="frontControllerServlert5",urlPatterns = "/front-controller/v5/*")
public class FrontControllerServlet5 extends HttpServlet{

    private final Map<String,Object> handleMappingMap=new HashMap<>();
    private final List<MyHandlerAdapter>handlerAdapter=new ArrayList<>();

    public FrontControllerServlet5(){
            initHandlerAdapters();
            //핸들러를 넣어주는 로직
            initHandlerMappintmap();
            //핸들러 어댑터를 넣어주는 로직
    }

    private void initHandlerAdapters(){
        handlerAdapter.add(new ControllerV4HandlerAdapter());
        handlerAdapter.add(new ControllerV3HandlerAdapter());
    }
    private void initHandlerMappintmap(){
        //핸들러 매핑맵이 핸들러를 찾아준다.
        handleMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handleMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handleMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handleMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handleMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handleMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler=getHandler(request);
        // 핸들러를 찾아와라
        if(handler==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyHandlerAdapter adapter=getHandlerAdapter(handler);
        //핸들러 어댑터를 찾아와라
        ModelView mv=adapter.handle(request,response,handler);
        String viewname=mv.getViewname();
        MyView view=viewResolver(viewname);
        view.render(mv.getModel(),request,response);
    }
    private  Object getHandler(HttpServletRequest req){
        String requestUrl=req.getRequestURI();
        Object oj=handleMappingMap.get(requestUrl);
        return oj;
    }
    //핸들러 어댑터를 뒤져서 핸들러 어댑터를 가져옴
    private  MyHandlerAdapter getHandlerAdapter(Object handler){
        MyHandlerAdapter a;
        // 어댑터가 핸들러를 지원하는가?
        //MemberFormControllerV4
        for(MyHandlerAdapter adapter:handlerAdapter){
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        throw  new IllegalArgumentException("ds");
    }
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }



}