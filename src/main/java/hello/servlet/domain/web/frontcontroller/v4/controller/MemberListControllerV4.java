package hello.servlet.domain.web.frontcontroller.v4.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;

import hello.servlet.domain.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private  MemberRepository memberRepository=MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> parammap, Map<String, Object> model) {
        List<Member>members=memberRepository.findAll();
        model.put("members",members);

        return "memebers";




    }


    //    private MemberRepository memberRepository = MemberRepository.getInstance();
//
//    public String process(Map<String, String> paramMap, Map<String, Object> model) {
//        List<Member> members = memberRepository.findAll();
//        model.put("members",members);
//        return "members";
//    }

//    private MemberRepository memberRepository=MemberRepository.getInstance();
//
//    @Override
//    public String process(Map<String, String> paramap, Map<String, Object> model) {
//        List<Member>members=memberRepository.findAll();
//        model.put("members",members);
//        return "members";
//
//    }
}
