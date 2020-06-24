package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

//Table
//�Һ���ɵ� �Ẹ�� 
@Data
@Entity
//Entity��ü
@Component //4���� stereotype (Controller, Service, Repository, Component) �� �װ����� �ֳ����̼��س��� Ŭ������ �������� ���ɶ� �����ɶ� �޸𸮿� new�� �Ǿ� �ν��Ͻ�ȭ �Ǿ�����. ���߿� �̰͵��� @Autowired�� �Ἥ
//VO(value��� ��ü)
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name="test";
	private String gender;
	private String kind;
}           
//������: alt + shift + a
//DDD Domain Driven Development