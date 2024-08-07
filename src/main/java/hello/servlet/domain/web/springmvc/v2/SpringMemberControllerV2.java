package hello.servlet.domain.web.springmvc.v2;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//중복되는 url 처리 상단에 requestmapping+ 하부에 requestmapping
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private MemberRepository memberRepository=MemberRepository.getInstance();
    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        int age =Integer.parseInt(request.getParameter("age"));

        Member member=new Member(username,age);
        memberRepository.save(member);

        ModelAndView mv2=new ModelAndView("save-result");
        //mv2.getModel().put("member",member);
        mv2.addObject("member",member);
        return mv2 ;

    }
    @RequestMapping("/members")
    public ModelAndView Members() {
        List<Member> members=memberRepository.findAll();
        ModelAndView mv=new ModelAndView("members");
        // mv.getModel().put("members",members);
        mv.addObject("members",members);
        return mv;
    }
}
