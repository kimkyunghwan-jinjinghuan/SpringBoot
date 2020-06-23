package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.model.Member;

@Controller
public class WelcomeController {
	@GetMapping("/welcome")
	public String welcome(Model model) {
		List<String> list = new ArrayList<>();
		list.add("list1");
		list.add("list2");
		model.addAttribute("list", list);
		Map<String, Object> map = new HashMap<>();
		map.put("key1", "map1");
		map.put("key2", "map2");
		model.addAttribute("map", map); //키:map, map변수(주소를 가지고있음)
		Member member = new Member(); //DTO객체, (더 세련된 표현)VO객체
		member.setUserId("a");
		member.setName("spring");
		member.setUserPassword("1234");
		model.addAttribute("member", member);
		model.addAttribute("message", "thymeleaf");
		
		
		
		
		
		map.put("m", member);// m이라는 키로 memeber를 집어넣는다
		
		return "welcome"; 
	}
}
