package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.basic.model.Member;

@Controller
public class HtmlController {
	@GetMapping("html/string")
	//              ===> View로 데이터전달
	public String html(Model model){
		//					키 		밸류
		model.addAttribute("msg", "자바"); // 키 - 밸류 , json의 document, 맵, 리스트 등 밸류값에 들어갈 수 있다
		Map map = new HashMap();
		map.put("name", "홍길동");
		map.put("address", "제주도");
//		맵을 모델에 넣기
		model.addAttribute("person", map);
		return "html/string"; //이건 파일명으로 가는거 string.html
	}

	@GetMapping("html/void")
	public void htmlVoid() {
	}

	@GetMapping("html/map")
	public Map<String, Object> htmlMap(Map<String, Object> map) {
		Map<String, Object> map2 = new HashMap<String, Object>();
		return map2;
	}

	@GetMapping("html/model")
	public Model htmlModel(Model model) {
		return model;
	}

	@GetMapping("html/model_and_view")
	public ModelAndView htmlModel() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("html/model_and_view");
		return mav;
	}

	@GetMapping("html/object")
	public Member htmlObject() {
		Member member = new Member();
		member.setName("kim");
		return member;
	}
}