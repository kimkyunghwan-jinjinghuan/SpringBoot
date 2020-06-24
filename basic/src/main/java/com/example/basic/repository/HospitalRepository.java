package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> { //Long이 key <테이블명(클래스), 프라이머리키자료형> <k, v>. 데이터베이스JPA
	
	public abstract Hospital findByName(String name); //abstract생략가능 , public도 생략가능
//	public List<Hospital> findAllByAddressContaining(String address); //여러건이 나온다
	public List<Hospital> findAllByAddressContainingOrderByIdDesc(String address); //여러건이 나오는데 순서 를 Id내림차순으로
	//List구조에 Hospital타입 find메소드명(자료형 파라미터변수) 명세를 적어놓고
	
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Animal, Integer> { //Long이 key
//} VO객체에 int id로 했으면 Integer로.