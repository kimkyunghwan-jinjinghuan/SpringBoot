package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity // ��� ���� �������Ѵ�. ��=��ƼƼ=VO
public class Member { 
	//VO�Ǵ� DTO����ϴ� Ŭ����
	//Ŭ���̾�Ʈ�� �Ѱ��� �����͸� 
	//dao�𵨷� �����ͺ��̽����� Ŭ������ �Ѱ��ֱ� ���ؼ�
	//null�� �ɼ��� 3���ۿ� �����Ͱ� �������� �� �� �ִ�. Ŭ������ ������ ��������. ����� ���� ����
	//�� �ѱ�� �ϳ��� ��� �ѱ�� ����
	//Data Transfer Object
	//Value Object
	//�̷��� Set/Get�޼ҵ尡 �־���Ѵ� setter, getter
	
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
//spring.jpa.hibernate.ddl-auto=none �̶� �ٷ� �ٷ� �ٲ��� �ʴ´�
//@Transient ����� �����ͺ��̽��ʹ� �����ϴ� , ��񿡴� ���� �ʰ�, �����ͺ��̽��� ������ ���� �ʴ´�