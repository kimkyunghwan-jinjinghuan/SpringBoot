package com.example.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/free") //free?title=000�� ȣ��
	public String free(Model model, String title) {
		model.addAttribute("title", title);
		return "index"; //��Ʈ�ѷ��� ���ļ�  http://localhost:8080/free       xxx.html���·� ȣ���� ���ϳ� html�� ���ϸ�����
	}
	
	//Log4j��� �� -> slf4j
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		
		
		System.out.println("print");
		logger.trace("trace!");
		logger.debug("debug!");
		logger.warn("warn!");
		logger.error("error!");

		return "home";
		
		
		
		
		
		
		
		
		
		
	}
}
