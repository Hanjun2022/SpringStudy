package hello.servlet.domain.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView{
    private String viewname;
    // 뷰의 논리적이름을 받고
    private Map<String,Object>model=new HashMap<>();
    // 모델을 반환


    public String getViewname() {
        return viewname;
    }



    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
    public void setViewname(String viewname) {
        this.viewname = viewname;
    }

    public ModelView(String name){
        viewname=name;
    }
}