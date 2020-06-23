package com.example.basic.model;

import lombok.Data;

@Data
public class Member { 
	//VO또는 DTO라고하는 클래스
	//클라이언트가 넘겨준 데이터를 
	//dao모델로 데이터베이스관련 클래스에 넘겨주기 위해서
	//null이 될수도 3개밖에 데이터가 여러건이 들어갈 수 있다. 클래스에 변수를 만들어놓고. 가방과 같은 역할
	//뭘 넘기든 하나로 묶어서 넘기는 원리
	//Data Transfer Object
	//Value Object
	//이런건 Set/Get메소드가 있어야한다 setter, getter
	private String name;
	private String userId;
	private String userPassword;
}