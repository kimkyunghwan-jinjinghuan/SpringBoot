package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@Column(name ="id")
	int id;
	String name;
	int age;
	String grade;
	String job;
	int point;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	Order order;
	
	
	
}
