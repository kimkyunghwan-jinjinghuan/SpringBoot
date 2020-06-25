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
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("/sign_in") //free?title=000�� ȣ�� localhost:8080/sign_upȣ��. �ٹ��
	public String sign_in() {
		return "sign_in"; //��Ʈ�ѷ��� ���ļ�  http://localhost:8080/free       xxx.html���·� ȣ���� ���ϳ� html�� ���ϸ�����.  sign_up.html��
	}
	
	
	//ȸ������ȭ��  sign_up.html�� post������� 
	@PostMapping("/sign_up") //free?title=000�� ȣ�� localhost:8080/sign_upȣ��. ����Ʈ���
	@ResponseBody
	public Member signUpPost(@ModelAttribute Member member) {       //String ->Member��, Model(������, �����ͺ��̽� ���̺�)
		return 	mr.save(member);
		 //��Ʈ�ѷ��� ���ļ�  http://localhost:8080/free       xxx.html���·� ȣ���� ���ϳ� html�� ���ϸ�����
	}
	
	
	
	@PostMapping("/logintest")
	@ResponseBody
	public String logintest(@ModelAttribute Member member, HttpSession session) {
		
		Member num = mr.findByNumAndName(member.getNum(), member.getName());
		if(num != null) {
			session.setAttribute("member", member);
			return "1";
		} else {
			return "0";
		}
	}
	
	
	
	@PostMapping("/login2")
	public String loginTest(@ModelAttribute Member member, HttpSession session) {  //�Է¹޴��������Ͱ����� member�� �ϳ��� ���̺���(��)�� ������ member�� ����. ���ڷ� Ŭ������������ ���ο��� ��ü�����ĸ޼ҵ�Ȱ��
		System.out.println(member);
		
		// id�� ������?
		if(null == mr.findByNum(Integer.parseInt(member.getUserId()))) {
			return "redirect:/login3";
		}
		Member result =  mr.findById(Integer.parseInt(member.getUserId())).get(); //�ڷ����� �׻� üũ�������
		System.out.println(result);
		if(result.getName().equals(member.getUserPassword())){
			session.setAttribute("member", result); // <Member, Integer>�� �򰥷ȴ� setAttribute("member", result) --> (k, v). ���̵��°��� key�� ���ν����ش� (key,value)
			return "main"; // main.html <= response ȭ��
		}
		else { // ����� Ʋ����?
			return "redirect:/login3"; // <= �������� �ּ� ����
		}
	
	}
	@GetMapping("/login2")
	public String loginTest2() {  
		//loginTest2() �޼ҵ��ߺ��ȵȴ�. �����ε����δ� ����.
		//�Է¹޴��������Ͱ����� member�� �ϳ��� ���̺���(��)�� ������ member�� ����. ���ڷ� Ŭ������������ ���ο��� ��ü�����ĸ޼ҵ�Ȱ��
		return "login2";
	}
	
	
	


	
	
	
}
