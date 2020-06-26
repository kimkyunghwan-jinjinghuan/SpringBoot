package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Emp {
	
	@Id
	@Column(name ="EMPNO")
	int empno;
	
	@Column(name ="ENAME")
	String ename;
	String job;
	int mgr;
	String hiredate;
	int sal;
	int comm;
	
	
//	중요한코드 연관관계를 일으키는 코드
	@ManyToOne
	@JoinColumn(name="deptno")
	Dept dept;
	
	
	
}
