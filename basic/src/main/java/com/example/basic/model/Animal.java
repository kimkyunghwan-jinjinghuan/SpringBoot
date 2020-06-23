package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//Table
@Data
@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String gender;
	String kind;
}
