package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> { //Long�� key <���̺��(Ŭ����), �����̸Ӹ�Ű�ڷ���> <k, v>. �����ͺ��̽�JPA
	
	public abstract Hospital findByName(String name); //abstract�������� , public�� ��������
//	public List<Hospital> findAllByAddressContaining(String address); //�������� ���´�
	public List<Hospital> findAllByAddressContainingOrderByIdDesc(String address); //�������� �����µ� ���� �� Id������������
	//List������ HospitalŸ�� find�޼ҵ��(�ڷ��� �Ķ���ͺ���) ���� �������
	
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Animal, Integer> { //Long�� key
//} VO��ü�� int id�� ������ Integer��.