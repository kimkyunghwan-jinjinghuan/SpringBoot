package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Customer;
import com.example.basic.model.Emp;
import com.example.basic.repository.CustomerRepository;


@Controller
public class CustomerController {
	@Autowired
	CustomerRepository cr;

	@GetMapping("/customer") // �����ִ�
	public String Customer(Model model) {
		List<Customer> list = cr.findAll();
		model.addAttribute("list",list); //�𵨿� ��´� ����Ʈ ����Ʈ��ü
		for(Customer c : list) {
			System.out.printf("%s %s", 
					c.getOrder().getDest(),
					c.getOrder().getOrdDate());
		}
		
		return "customer"; // write.html������ html template
	}
	
}



