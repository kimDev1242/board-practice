package com.practice.project.service;

import com.practice.project.domain.Article;
import com.practice.project.domain.ArticleComment;
import com.practice.project.domain.UserAccount;

import com.practice.project.domain.type.SearchType;
import com.practice.project.dto.ArticleCommentDto;
import com.practice.project.dto.ArticleDto;
import com.practice.project.repository.ArticleCommentRepository;
import com.practice.project.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(long articleId) {
        return List.of();
    }
    public void saveArticleComment(ArticleCommentDto dto) {
    }

    public void updateArticleComment(ArticleCommentDto dto) {
    }

    public void deleteArticleComment(Long articleCommentId) {
    }
}
