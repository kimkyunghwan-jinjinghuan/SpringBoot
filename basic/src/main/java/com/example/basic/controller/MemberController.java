package com.example.basic.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;
import com.example.basic.repository.MemberRepository;

@Controller
public class MemberController {
	@Autowired MemberRepository mr; //jpa쓰기 전에 디비연결위해 어노테이션 적어주고  @Autowired
	
	
	@GetMapping("/sign_up") //free?title=000로 호출 localhost:8080/sign_up호출. 겟방식
	public String signUp() {
		return "sign_up"; //컨트롤러를 거쳐서  http://localhost:8080/free       xxx.html형태로 호출을 안하네 html의 파일명만으로.  sign_up.html로
	}
	
	
	//회원가입화면  sign_up.html과 post방식으로 
	@PostMapping("/sign_up") //free?title=000로 호출 localhost:8080/sign_up호출. 포스트방식
	@ResponseBody
	public Member signUpPost(@ModelAttribute Member member) {       //String ->Member로, Model(데이터, 데이터베이스 테이블)
		return 	mr.save(member);
		 //컨트롤러를 거쳐서  http://localhost:8080/free       xxx.html형태로 호출을 안하네 html의 파일명만으로
	}
	
	
	
	@PostMapping("/logintest")
	public String loginTest(@ModelAttribute Member member, HttpSession session) { //입력받는폼데이터값들이 member에 하나의 테이블행(로)가 통으로 member에 담기고. 인자로 클래스도들어오고 내부에서 객체생성후메소드활용
		System.out.println(member);
		if(null == mr.findIdById(member.getUserId())) {
			return "redirect:/logintest";
		}
		Member result =  (Member) mr.findById(member.getUserId()); //자료형을 항상 체크해줘야혀
		System.out.println(result);
		if(result.getUserPassword().equals(member.getUserPassword())){
			session.setAttribute("member", result); // <Member, Integer>랑 헷갈렸다 setAttribute("member", result) --> (k, v). 값이들어온것을 key와 맵핑시켜준다 (key,value)
			return "main";
		}
		else {
			return "redirect:/logintest";
		}
	}
	
	
	
	
	/*
	 @RequestMapping("/login")
	    public ModelAndView loginForm(Member member,
	                    @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
	        
	        if(rememberCookie!=null) { //자동로그인
	            loginCommand.setId(rememberCookie.getValue());
	            loginCommand.setRememberId(true);
	        }
	        
	        ModelAndView mv = new ModelAndView("user/login/loginForm");
	        return mv;
	    }
	 
	 */


	
	
	
}
