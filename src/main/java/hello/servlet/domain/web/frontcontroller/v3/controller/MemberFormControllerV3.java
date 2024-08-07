package hello.servlet.domain.web.frontcontroller.v3.controller;

import hello.servlet.domain.web.frontcontroller.ModelView;
import hello.servlet.domain.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

//public class MemberFormControllerV3 implements ControllerV3 {
//    @Override
//    public ModelView process(Map<String, String> paramMap) {
//        //논리적인 이름을 둔다.
//        return new ModelView("new-form");
//    }
//}

public class MemberFormControllerV3 implements ControllerV3{
    @Override
    public ModelView process(Map<String,String>paramMap){
        return new ModelView("new-form");
    }
}