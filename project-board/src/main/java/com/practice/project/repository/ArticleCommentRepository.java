package com.practice.project.repository;


import com.practice.project.domain.Article;
import com.practice.project.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;



public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long>{



}