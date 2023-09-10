package com.practice.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private Article article; // 게시글 (ID)

    @Setter @Column(nullable = false, length = 500) private String content; // 본문

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)// 연습용 2023
    private Set<ArticleComment> childComments = new LinkedHashSet<>();

    @CreatedBy
    @Column(nullable = false)
    private String createdBy; // 제목

    @CreatedDate
    @Column(nullable = false, length = 100)private LocalDateTime createdAt;

    @CreatedDate @Column(nullable = false, length = 100)private LocalDateTime modifiedAt;
    @CreatedBy
    @Column(nullable = false)
    private String modifiedBy; // 제목




    protected ArticleComment() {}

    private ArticleComment(Article article,  String content) {
        this.article = article;

        this.content = content;
    }

    public static ArticleComment of(Article article,  String content) {
        return new ArticleComment(article,  content);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}