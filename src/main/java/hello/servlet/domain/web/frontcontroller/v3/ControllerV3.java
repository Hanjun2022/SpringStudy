package hello.servlet.domain.web.frontcontroller.v3;



import hello.servlet.domain.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3  {

    ModelView process(Map<String,String>paramap);
}