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

	@GetMapping("/emp") // �����ִ�
	public String Emp(Model model) {
		List<Emp> list = er.findAll();
		model.addAttribute("list",list); //�𵨿� ��´� ����Ʈ ����Ʈ��ü
		for(Emp e : list) {
			System.out.printf("%s %s", 
					e.getDept().getDname(),//dept
					e.getEname());
		}
		
		return "emp"; // write.html������ html template
	}
	
}




































//�޸�
// @ModelAttribute Article article html������ ���� ������ PostMapping���ļ�
// MultipartHttpServletRequest mRequest ���� �Ͱ� ���� �ٸ� Ÿ��