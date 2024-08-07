package hello.servlet.domain.web.frontcontroller.v5.adapter;

import hello.servlet.domain.web.frontcontroller.ModelView;
import hello.servlet.domain.web.frontcontroller.v4.ControllerV4;
import hello.servlet.domain.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controllerV4=(ControllerV4) handler;
        //캐스팅
//        Map<String,String> paramMap=createParamMap(request);
//        HashMap<String,Object>model=new HashMap<>();
//        //ControllerV4 코드가 비슷하다.
//        String viewName= controllerV4.process(paramMap,model);
//        //컨트롤러가 모델이 필요한 데이터를 담아놓는다.
//
//        //110V->220V;  //이름을 모델뷰를 만들고 모델뷰를 반환해주어야한다.
//       ModelView mv= new ModelView(viewName);
//       mv.setModel(model);
//
//        return mv;
        Map<String,String>paramMap=createParamMap(request);
        Map<String,Object>model=new HashMap<>();
        String viewName=controllerV4.process(paramMap,model);
        ModelView mv=new ModelView(viewName);
        mv.setModel(model);
        return mv;
    }
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }
    private Map<String,String> createParamMap(HttpServletRequest request){
        Map<String,String>paramMap=new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paraName
                ->paramMap.put(paraName,request.getParameter(paraName)));
        return paramMap;
    }
}
