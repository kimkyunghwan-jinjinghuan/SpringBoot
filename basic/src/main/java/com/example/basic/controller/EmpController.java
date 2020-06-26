package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Animal;
import com.example.basic.model.Article;
import com.example.basic.model.Emp;
import com.example.basic.model.Tree;
import com.example.basic.repository.EmpRepository;


@Controller
public class EmpController {
	@Autowired
	EmpRepository er;

	@GetMapping("/emp") // 보여주는
	public String Emp(Model model) {
		List<Emp> list = er.findAll();
		model.addAttribute("list",list); //모델에 담는다 리스트 리스트객체
		for(Emp e : list) {
			System.out.printf("%s %s", 
					e.getDept().getDname(),//dept
					e.getEname());
		}
		
		return "emp"; // write.html만들어야 html template
	}
	
}




































//메모
// @ModelAttribute Article article html폼에서 받은 데이터 PostMapping거쳐서
// MultipartHttpServletRequest mRequest 위의 것과 서로 다른 타입