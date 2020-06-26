package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;
import com.example.basic.model.Dept;
import com.example.basic.model.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> { //Long�� key
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Animal, Integer> { //Long�� key
//} VO��ü�� int id�� ������ Integer��.