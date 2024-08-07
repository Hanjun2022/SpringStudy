package hello.servlet.domain.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Controllerv1 {
   default void process(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

   }
}