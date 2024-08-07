package hello.servlet.domain.web.frontcontroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.domain.web.frontcontroller.ModelView;
import hello.servlet.domain.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
//    private MemberRepository memberRepository=MemberRepository.getInstance();
//    @Override
//    public ModelView process(Map<String, String> paramMap) {
//        //map 에 다가 모든 정보를 저장하고 뺴서 쓴다.
//       String username= paramMap.get("username");
//       int age=Integer.parseInt(paramMap.get("age"));
//
//        Member member=new Member(username,age);
//        memberRepository.save(member);
//
//        ModelView mv=new ModelView("save-result");
//        //필요한 ModelView에 정보를 담아서 반환해준다.
//        mv.getModel().put("member",member);;
//        return mv;
//    }

    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramap) {
       String username=paramap.get("username");
       int age =Integer.parseInt(paramap.get("age"));

       Member member=new Member(username,age);
       memberRepository.save(member);
       //Map<String,String>으로 받아온 정보를 member로 해서 memberRepository에 저장

       ModelView mv2=new ModelView("save-result");
       mv2.getModel().put("member",member);
       //ModelView로 넣어서 저장

       return mv2 ;

    }
}
