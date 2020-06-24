package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

//Table
//롬복기능도 써보자 
@Data
@Entity
//Entity객체
@Component //4종류 stereotype (Controller, Service, Repository, Component) 이 네가지의 애노테이션해놓은 클래스는 스프링이 사용될때 구동될때 메모리에 new가 되어 인스턴스화 되어진다. 나중에 이것들을 @Autowired를 써서
//VO(value담는 객체)
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name="test";
	private String gender;
	private String kind;
}           
//열편집: alt + shift + a
//DDD Domain Driven Development