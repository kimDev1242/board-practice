package com.practice.project.controller;


import com.practice.project.dto.UserAccountDto;
import com.practice.project.dto.request.ArticleCommentRequest;
import com.practice.project.dto.security.BoardPrincipal;
import com.practice.project.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping ("/new")
    public String postNewArticleComment(
            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
            ArticleCommentRequest articleCommentRequest
    ) {
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(boardPrincipal.toDto()));


        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping ("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable Long commentId, Long articleId) {
        articleCommentService.deleteArticleComment(commentId);

        return "redirect:/articles/" + articleId;
    }

}