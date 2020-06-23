package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;
import com.example.basic.model.Tree;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> { //Long¿Ã key
}