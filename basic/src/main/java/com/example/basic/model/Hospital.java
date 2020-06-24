package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Hospital {
	@Id
	int id;
	String sido;
	String name;
	int medical;
	int room;
	String tel;
	String address;
	double lat;
	double lng;
}

//엔티티, 클래스, 데이터베이스의 테이블