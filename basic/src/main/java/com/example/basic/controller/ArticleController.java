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

	@GetMapping("/article") // �����ִ�
	public String article(Model model) {
		List<Article> list = atr.findAll();
		model.addAttribute("list", list);// select All ��ȸ��
		return "article"; // write.html������
	}
	
}




































//�޸�
// @ModelAttribute Article article html������ ���� ������ PostMapping���ļ�
// MultipartHttpServletRequest mRequest ���� �Ͱ� ���� �ٸ� Ÿ��