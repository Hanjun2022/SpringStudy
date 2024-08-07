package hello.servlet.domain.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath){
        this.viewPath=viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    public void render(Map<String,Object> model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model,request);
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
    public void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        //.jsp는 setAttribute를 씀 model로 리퀘스트를 할때 여기서 뷰렌더링작업 때 보내준다. Member 및 List
        model.forEach((key, value) -> {
            request.setAttribute(key, value);
            System.out.println("key= " + key + ", value = " + value);
        });
        //request에 모든 정보를 저장한다. model에 있는 정보를 requestAttribute로 바꾼다.
        //request에 값을 다 담아둔다.
    }

}
