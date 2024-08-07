package hello.servlet.domain.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
//너가 입력한거를 보낸 데이터를 그대로 화면에 나오게 한다.
// getInputStream()

@WebServlet(name="requestbodyStringServlegt",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ServletInputStream inputStream= request.getInputStream();
       String messageBody= StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = "+messageBody);
        response.getWriter().write("OK");
        return ;
    }
}
