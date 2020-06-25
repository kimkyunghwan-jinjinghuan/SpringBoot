package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;
import com.example.basic.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

//	Object findIdById(String userId);;
//		//�� key �����̸Ӹ�Ű, Į����NUM, ������Ÿ�� INT��� member���̺�Ű������ ������
//	
//	Object findById(String userId);
	Member findByNumAndName(int num, String name);

	public Member findByNum(int userId);
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Member, Integer> { //Long�� key
//} VO��ü�� int id�� ������ Integer��.