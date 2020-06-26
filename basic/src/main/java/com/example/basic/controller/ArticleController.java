package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Animal;
import com.example.basic.model.Article;
import com.example.basic.model.Tree;
import com.example.basic.repository.ArticleRepository;


@Controller
public class ArticleController {
	@Autowired
	ArticleRepository atr;

	@GetMapping("/article") // 보여주는
	public String article(Model model) {
		List<Article> list = atr.findAll();
		model.addAttribute("list", list);// select All 조회시
		return "article"; // write.html만들어야
	}
	
}




































//메모
// @ModelAttribute Article article html폼에서 받은 데이터 PostMapping거쳐서
// MultipartHttpServletRequest mRequest 위의 것과 서로 다른 타입