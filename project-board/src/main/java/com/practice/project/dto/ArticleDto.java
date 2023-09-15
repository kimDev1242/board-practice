package com.practice.project.dto;

import com.practice.project.domain.Article;
import com.practice.project.domain.UserAccount;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleDto(
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy
) implements Serializable {

    public static ArticleDto of( LocalDateTime createdAt, String createdBy,String title, String content, String hashtag) {
        return new ArticleDto( title, content, hashtag,createdAt, createdBy);
    }




}