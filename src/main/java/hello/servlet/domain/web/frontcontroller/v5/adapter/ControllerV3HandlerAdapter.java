package hello.servlet.domain.web.frontcontroller.v5.adapter;

import hello.servlet.domain.web.frontcontroller.ModelView;
import hello.servlet.domain.web.frontcontroller.v3.ControllerV3;
import hello.servlet.domain.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
//    @Override
//    public boolean supports(Object handler) {
//        return handler instanceof  ControllerV3;
//    }
//
//    @Override
//    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
//   ControllerV3 controllerV3=(ControllerV3)handler;
//   Map<String,String>paramMap=createParamMap(request);
//   //V3에서 정보를 가져와서
//   ModelView mv=controllerV3.process(paramMap);
//   //V3는 Map을 이런식으로 호출하니까
//   return mv;
//    }
//
//
//    public Map<String,String>createParamMap(HttpServletRequest req){
//        Map<String,String>m=new HashMap<>();
//        req.getParameterNames().asIterator().forEachRemaining(paraname->m.put(paraname,req.getParameter(paraname)));
//        return m;
//    }



    @Override
    public boolean supports(Object handler) {
        return handler instanceof  ControllerV3;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws IOException, ServletException {
        ControllerV3 controllerV3=(ControllerV3) Handler;
        Map<String,String>paramMap=createParamMap(request);
        ModelView mv=controllerV3.process(paramMap);
        return mv;
    }

    private Map<String,String>createParamMap(HttpServletRequest req){
        Map<String,String>map=new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(paraname->map.put(paraname,req.getParameter(paraname)));
        return map;
    }
}
