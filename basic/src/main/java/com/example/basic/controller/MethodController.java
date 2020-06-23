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
	// Ŭ���̾�Ʈ�� ��û�� �޾��ִ� ���(�ֳ����̼�)
	// 1. @RequestParam
	// 2. @ModelAttribute
	
	public String get(String page, @RequestParam(name = "page_no", defaultValue = "1" ) String value) {
		//@RequestParam�� name�� �� �־��
		return "GET" + page;
	} 

	@GetMapping("req/post") //GetMapping�� PostMapping�̾��µ� �ߺ��Ǿ �ȵǾ���
	public String post2() {
		return "POST_GET";
	}
	//�ּҴ� �ϳ��� �پ��� ������� ���� �ٹ���̳� ����Ʈ������� ȣ���ϴ���
	
	@PostMapping("req/post") //post������� �Ѱ���� ������ 
	public String post(String page) {
		return "POST" + page ;
	}
}