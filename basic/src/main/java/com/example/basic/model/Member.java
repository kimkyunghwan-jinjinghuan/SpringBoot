package com.example.basic.model;

import lombok.Data;

@Data
public class Member { 
	//VO�Ǵ� DTO����ϴ� Ŭ����
	//Ŭ���̾�Ʈ�� �Ѱ��� �����͸� 
	//dao�𵨷� �����ͺ��̽����� Ŭ������ �Ѱ��ֱ� ���ؼ�
	//null�� �ɼ��� 3���ۿ� �����Ͱ� �������� �� �� �ִ�. Ŭ������ ������ ��������. ����� ���� ����
	//�� �ѱ�� �ϳ��� ��� �ѱ�� ����
	//Data Transfer Object
	//Value Object
	//�̷��� Set/Get�޼ҵ尡 �־���Ѵ� setter, getter
	private String name;
	private String userId;
	private String userPassword;
}