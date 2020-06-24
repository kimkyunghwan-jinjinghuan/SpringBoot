package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.Hospital;
import com.example.basic.repository.HospitalRepository;

@RestController

public class HospitalController {
	@Autowired
	HospitalRepository hr;
	
	
	@GetMapping("/hospital")
	public Hospital get(String name) {
		Hospital hospital = hr.findByName(name);
		return hospital;
	}
	
	@GetMapping("/hospital_list")
	public List<Hospital> getList(String address) { //getList()
		 List<Hospital> hospitalList = hr.findAllByAddressContainingOrderByIdDesc(address); //findAllBy�����޼ҵ� ���� ���� ã�Ƽ�  ����Ʈ�� �ְ� return
		 return hospitalList;
	}
	
	
	
	
}
