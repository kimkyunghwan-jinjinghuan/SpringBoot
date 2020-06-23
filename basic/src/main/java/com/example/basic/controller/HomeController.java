package com.example.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/free") //free?title=000로 호출
	public String free(Model model, String title) {
		model.addAttribute("title", title);
		return "index"; //컨트롤러를 거쳐서  http://localhost:8080/free       xxx.html형태로 호출을 안하네 html의 파일명만으로
	}
	
	//Log4j라고 함 -> slf4j
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
