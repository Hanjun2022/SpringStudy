package hello.servlet.domain.web.frontcontroller.v5;

import hello.servlet.domain.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.Banner;

import java.io.IOException;
import java.net.http.HttpRequest;


public interface MyHandlerAdapter{

  boolean supports(Object handler);

  ModelView handle(HttpServletRequest request,HttpServletResponse response,Object Handler) throws IOException,ServletException;

}