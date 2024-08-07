package hello.servlet.domain.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    String process(Map<String,String>parammap,Map<String,Object>model);
}
