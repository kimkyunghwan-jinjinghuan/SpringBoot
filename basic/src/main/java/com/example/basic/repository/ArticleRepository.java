package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Animal;
import com.example.basic.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> { //Long¿Ã key
}
