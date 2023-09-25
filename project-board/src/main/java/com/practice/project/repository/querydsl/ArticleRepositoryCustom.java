package com.practice.project.repository.querydsl;

import java.util.List;

import com.practice.project.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
public interface ArticleRepositoryCustom {

    List<String> findAllDistinctHashtags();
    Page<Article> findByHashtagNames(Collection<String> hashtagNames, Pageable pageable);
}