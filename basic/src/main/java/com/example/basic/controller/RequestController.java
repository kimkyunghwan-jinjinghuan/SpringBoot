package com.example.basic.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.basic.model.Member;

//ResponseBody�Ǵ� RestController�� �ٷ� HTML�� �����ִ� html�� ���θ���?
@RestController 
public class RequestController {
	@GetMapping("req/model")
	public String model(@ModelAttribute Member member) { //�ش� Ŭ������ ���� F3 ����� f3������ Ŭ�������
		
		
		// @ReqyestPara Map  => Mybatis
		// @ModelAttribute DTO => JPA
		/*
		public String model(HttpServletRequest request, @ModelAttribute Member member) { //�ش� Ŭ������ ���� F3 ����� f3������ Ŭ�������
		�̰� ���ص� �ȴ�. �ڵ尡 �پ���. �Ʒ� 4���� �ڵ带 ����Ͽ� @ModelAttribute�ϳ��� �ȴ�
		HttpServletRequest request
		String name = request.getParameter("name");
		Member m = new Member();
		m.setName(name);
		*/
		
		return member.toString();
	}

	@GetMapping("req/path/{path1}/{path2}")
	public String path(HttpServletRequest request, @PathVariable("path1") String path1,
			@PathVariable("path2") String path2) {
		return path1 + ", " + path2;
	}

	@GetMapping("req/param2")
	public String param2(@RequestParam Map<String, Object> map) {
		return map.toString();
	}
//	http://localhost:8080/req/param2?a=1&��=A ��� �������ּ�â�� ��ġ�� {a=1, ��=A}��� ���´� , �̰� json���� ����ϱ� ���ؼ���? returnŸ���� map���� �ٲ��ش�.

	@GetMapping("req/param3")
	public Map<String, Object> param3(@RequestParam Map<String, Object> map) {
		return map;
	}

	@GetMapping("req/http")
	public String http(HttpServletRequest request) { // HttpServletRequest (jsp��), request.getParameter()
		String name = request.getParameter("name");
		String pageNum = request.getParameter("pageNum");
		return name + ", " + pageNum;
	}
}