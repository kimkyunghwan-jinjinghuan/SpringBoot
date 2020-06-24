package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.basic.model.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> { //Long�� key �ǵ帱 Tree���̺� Ŭ����
}