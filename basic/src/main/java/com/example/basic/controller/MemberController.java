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
	@Autowired MemberRepository mr; //jpa���� ���� ��񿬰����� ������̼� �����ְ�  @Autowired
	
	
	@GetMapping("/sign_up") //free?title=000�� ȣ�� localhost:8080/sign_upȣ��. �ٹ��
	public String signUp() {
		return "sign_up"; //��Ʈ�ѷ��� ���ļ�  http://localhost:8080/free       xxx.html���·� ȣ���� ���ϳ� html�� ���ϸ�����.  sign_up.html��
	}
	
	
	//ȸ������ȭ��  sign_up.html�� post������� 
	@PostMapping("/sign_up") //free?title=000�� ȣ�� localhost:8080/sign_upȣ��. ����Ʈ���
	@ResponseBody
	public Member signUpPost(@ModelAttribute Member member) {       //String ->Member��, Model(������, �����ͺ��̽� ���̺�)
		return 	mr.save(member);
		 //��Ʈ�ѷ��� ���ļ�  http://localhost:8080/free       xxx.html���·� ȣ���� ���ϳ� html�� ���ϸ�����
	}
	
	
	
	@PostMapping("/logintest")
	public String loginTest(@ModelAttribute Member member, HttpSession session) { //�Է¹޴��������Ͱ����� member�� �ϳ��� ���̺���(��)�� ������ member�� ����. ���ڷ� Ŭ������������ ���ο��� ��ü�����ĸ޼ҵ�Ȱ��
		System.out.println(member);
		if(null == mr.findIdById(member.getUserId())) {
			return "redirect:/logintest";
		}
		Member result =  (Member) mr.findById(member.getUserId()); //�ڷ����� �׻� üũ�������
		System.out.println(result);
		if(result.getUserPassword().equals(member.getUserPassword())){
			session.setAttribute("member", result); // <Member, Integer>�� �򰥷ȴ� setAttribute("member", result) --> (k, v). ���̵��°��� key�� ���ν����ش� (key,value)
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
	        
	        if(rememberCookie!=null) { //�ڵ��α���
	            loginCommand.setId(rememberCookie.getValue());
	            loginCommand.setRememberId(true);
	        }
	        
	        ModelAndView mv = new ModelAndView("user/login/loginForm");
	        return mv;
	    }
	 
	 */


	
	
	
}
