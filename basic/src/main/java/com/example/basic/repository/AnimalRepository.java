package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> { //Long이 key
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Animal, Integer> { //Long이 key
//} VO객체에 int id로 했으면 Integer로.