package com.example.basic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.Animal;
import com.example.basic.model.Tree;
import com.example.basic.model.User;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.TreeRepository;

//@RestController
@Controller
public class JpaController {
	@Autowired TreeRepository tr;
	@Autowired AnimalRepository ar;

	
	@Autowired
	Animal animal;
	
	
	//�����ε� overloading - �޼ҵ���� ����, ������ ����/����/������ �ٸ� ����. �޼ҵ�������
	@GetMapping("/animal_html")
	
	public String animal(Model model, HttpSession session) {
		User id = (User) session.getAttribute("user");
		if(id == null) {
			return "redirect:/login";
		}
	
//		System.out.println(animal); //�������� �˾Ƽ� new�� �ؼ� �޸𸮻� ��ϵ� ��ü�� autowired������̼� Ȱ���Ͽ� ������ �� �ִ�. ����ų �� �ִ�. ��animal syso�ϱ����� new������ ���µ��� �ֿܼ� ������.
		List<Animal> list = ar.findAll(); //select All ��ȸ��
		model.addAttribute("userlist", list); //Ű, ���
		return "animal";
	} //����Ÿ�� ���ߴ°ͱ��� String animal() { return list.toString();}
	//JDBC�ڵ庸�� �������ڵ� jpa�� �� ª��
	// model�� list�� add�ؾ��Ѵ� model. ("key", 
	
	
	
	
	
	
	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll(); //select All ��ȸ��
		return list;
	} //����Ÿ�� ���ߴ°ͱ��� String animal() { return list.toString();}
	//JDBC�ڵ庸�� �������ڵ� jpa�� �� ª��
	//
	
	
	
	
	
	@GetMapping("/tree_add")
	@ResponseBody
	public String tree_add() {
		Tree tree = new Tree();
		tree.setColor("RED");
		tree.setName("�ҳ���");
		tr.save(tree); //select All
		return "ok";
	}

//	@PostMapping("/tree")
//	public String productPost(@ModelAttribute Product product) {
//		
//		return "redirect:/jpa/product";
//	}
}