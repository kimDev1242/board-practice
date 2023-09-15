package com.practice.project.dto;


import com.practice.project.domain.Article;
import com.practice.project.domain.ArticleComment;
import com.practice.project.domain.UserAccount;

import java.time.LocalDateTime;

public record ArticleCommentDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
) {

    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy,LocalDateTime modifiedAt,String modifiedBy,String content) {
        return ArticleCommentDto.of(createdAt, createdBy, modifiedAt, modifiedBy,content);
    }

}