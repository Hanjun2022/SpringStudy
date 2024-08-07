package hello.servlet.domain.web.frontcontroller.v4.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.domain.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {


    private  MemberRepository memberRepository=MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> parammap, Map<String, Object> model) {

       String username= parammap.get("username");
       int age=Integer.parseInt(parammap.get("age"));
       Member member=new Member(username,age);

       model.put("member",member);

       memberRepository.save(member);

       return "save-result";

    }
}











//
////    private MemberRepository memberRepository=MemberRepository.getInstance();
////    public String process(Map<String,String>parammap,Map<String,Object>model){
////        String username= parammap.get("username");
////        int age=Integer.parseInt(parammap.get("age"));
////        Member member=new Member(username,age);
////        memberRepository.save(member);
////
////        model.put("member",member);
////        return "save-result";
////
////    }
//
//    private MemberRepository memberRepository=MemberRepository.getInstance();
//
//    @Override
//    public String process(Map<String, String> parammap, Map<String, Object> model) {
//        String username=parammap.get("username");
//        int age=Integer.parseInt(parammap.get("age"));
//
//        Member member=new Member(username,age);
//        memberRepository.save(member);
//
//        model.put("member",member);
//
//        return "save-result";
//
//    }
//}
