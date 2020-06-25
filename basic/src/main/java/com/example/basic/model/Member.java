package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity // 디비에 정보 보내야한다. 모델=엔티티=VO
public class Member { 
	//VO또는 DTO라고하는 클래스
	//클라이언트가 넘겨준 데이터를 
	//dao모델로 데이터베이스관련 클래스에 넘겨주기 위해서
	//null이 될수도 3개밖에 데이터가 여러건이 들어갈 수 있다. 클래스에 변수를 만들어놓고. 가방과 같은 역할
	//뭘 넘기든 하나로 묶어서 넘기는 원리
	//Data Transfer Object
	//Value Object
	//이런건 Set/Get메소드가 있어야한다 setter, getter
	
	@Id 
	private int num;
	private String name;
	private String email;
	private String phone;
	
	
	@Transient 
	private String userId;
	@Transient
	private String userPassword;
}
//spring.jpa.hibernate.ddl-auto=none 이라서 바로 바로 바뀌지 않는다
//@Transient 얘들은 데이터베이스와는 무관하다 , 디비에는 넣지 않게, 데이터베이스에 영향을 받지 않는다