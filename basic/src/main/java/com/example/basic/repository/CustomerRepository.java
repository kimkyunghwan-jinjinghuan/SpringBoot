package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Customer;
import com.example.basic.model.Order;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> { //Long�� key
}

//@Repository
//public interface AnimalRepository extends JpaRepository<Animal, Integer> { //Long�� key
//} VO��ü�� int id�� ������ Integer��.