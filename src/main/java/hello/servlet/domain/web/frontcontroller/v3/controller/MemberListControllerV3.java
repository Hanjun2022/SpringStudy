package hello.servlet.domain.web.frontcontroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.domain.web.frontcontroller.ModelView;
import hello.servlet.domain.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
private MemberRepository memberRepository=MemberRepository.getInstance();


    @Override
    public ModelView process(Map<String, String> paramap) {
        List<Member>members=memberRepository.findAll();
        ModelView mv=new ModelView("members");
        mv.getModel().put("members",members);
        //memberRepository에 내용을 다 꺼내서 List에 저장
        //List를 모델에 저장

        return mv;
    }
}
