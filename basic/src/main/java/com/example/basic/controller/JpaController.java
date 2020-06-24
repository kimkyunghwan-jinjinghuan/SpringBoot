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
	
	
	//오버로딩 overloading - 메소드명은 같고, 인자의 개수/종류/순서가 다른 형태. 메소드형제들
	@GetMapping("/animal_html")
	
	public String animal(Model model, HttpSession session) {
		User id = (User) session.getAttribute("user");
		if(id == null) {
			return "redirect:/login";
		}
	
//		System.out.println(animal); //스프링이 알아서 new를 해서 메모리상에 등록된 객체를 autowired어노테이션 활용하여 데려올 수 있다. 가르킬 수 있다. 현animal syso하기전에 new한적이 없는데도 콘솔에 찍힌다.
		List<Animal> list = ar.findAll(); //select All 조회시
		model.addAttribute("userlist", list); //키, 밸류
		return "animal";
	} //리턴타입 맞추는것까지 String animal() { return list.toString();}
	//JDBC코드보다 스프링코드 jpa가 더 짧게
	// model을 list에 add해야한다 model. ("key", 
	
	
	
	
	
	
	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll(); //select All 조회시
		return list;
	} //리턴타입 맞추는것까지 String animal() { return list.toString();}
	//JDBC코드보다 스프링코드 jpa가 더 짧게
	//
	
	
	
	
	
	@GetMapping("/tree_add")
	@ResponseBody
	public String tree_add() {
		Tree tree = new Tree();
		tree.setColor("RED");
		tree.setName("소나무");
		tr.save(tree); //select All
		return "ok";
	}

//	@PostMapping("/tree")
//	public String productPost(@ModelAttribute Product product) {
//		
//		return "redirect:/jpa/product";
//	}
}