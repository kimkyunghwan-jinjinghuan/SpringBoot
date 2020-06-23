package com.example.basic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.Animal;
import com.example.basic.model.Tree;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.TreeRepository;

@RestController
public class JpaController {
	@Autowired
	TreeRepository tr;
	@Autowired
	AnimalRepository ar;

	@GetMapping("/animal")
	@ResponseBody
	public String animal() {
		List<Animal> list = ar.findAll(); //select All 조회시
		return list.toString();
	}
	
	
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