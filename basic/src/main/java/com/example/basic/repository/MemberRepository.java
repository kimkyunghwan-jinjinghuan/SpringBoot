package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;
import com.example.basic.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

//	Object findIdById(String userId);;
//		//이 key 프라이머리키, 칼럼명NUM, 데이터타입 INT라고 member테이블스키마에서 명세보고
//	
//	Object findById(String userId);
	Member findByNumAndName(int num, String name);

	public Member findByNum(int userId);
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Member, Integer> { //Long이 key
//} VO객체에 int id로 했으면 Integer로.