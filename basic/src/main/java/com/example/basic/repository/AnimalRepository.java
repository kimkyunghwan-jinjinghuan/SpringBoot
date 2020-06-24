package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> { //Long�� key
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Animal, Integer> { //Long�� key
//} VO��ü�� int id�� ������ Integer��.