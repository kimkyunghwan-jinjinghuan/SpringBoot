package com.example.basic.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.basic.model.Member;

//ResponseBody또는 RestController는 바로 HTML로 보여주는 html을 못부른다?
@RestController 
public class RequestController {
	@GetMapping("req/model")
	public String model(@ModelAttribute Member member) { //해당 클래스로 들어갈때 F3 멤버에 f3눌러서 클래스까보기
		
		
		// @ReqyestPara Map  => Mybatis
		// @ModelAttribute DTO => JPA
		/*
		public String model(HttpServletRequest request, @ModelAttribute Member member) { //해당 클래스로 들어갈때 F3 멤버에 f3눌러서 클래스까보기
		이걸 안해도 된다. 코드가 줄어든다. 아래 4줄의 코드를 대신하여 @ModelAttribute하나로 된다
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
//	http://localhost:8080/req/param2?a=1&가=A 라고 브라우저주소창에 탕치니 {a=1, 가=A}라고 나온다 , 이거 json으로 출력하기 위해서는? return타입을 map으로 바꿔준다.

	@GetMapping("req/param3")
	public Map<String, Object> param3(@RequestParam Map<String, Object> map) {
		return map;
	}

	@GetMapping("req/http")
	public String http(HttpServletRequest request) { // HttpServletRequest (jsp용), request.getParameter()
		String name = request.getParameter("name");
		String pageNum = request.getParameter("pageNum");
		return name + ", " + pageNum;
	}
}