package com.example.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
	@GetMapping("req/get")
	@RequestMapping(value = "req/get", method = RequestMethod.GET)
	// 클라이언트의 요청을 받아주는 기능(애노테이션)
	// 1. @RequestParam
	// 2. @ModelAttribute
	
	public String get(String page, @RequestParam(name = "page_no", defaultValue = "1" ) String value) {
		//@RequestParam의 name은 꼭 있어야
		return "GET" + page;
	} 

	@GetMapping("req/post") //GetMapping이 PostMapping이었는데 중복되어서 안되었음
	public String post2() {
		return "POST_GET";
	}
	//주소는 하나로 다양한 방식으로 접근 겟방식이냐 포스트방식으로 호출하느냐
	
	@PostMapping("req/post") //post방식으로 넘겨줘야 반응이 
	public String post(String page) {
		return "POST" + page ;
	}
}