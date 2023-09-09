package com.practice.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtags"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문


    @Setter @Column(nullable = false)  private String hashtags;



    @CreatedBy
    @Column(nullable = false)
    private String createdBy; // 제목

    @CreatedDate @Column(nullable = false, length = 100)private LocalDateTime createdAt;

    @CreatedDate @Column(nullable = false, length = 100)private LocalDateTime modifiedAt;
    @CreatedBy
    @Column(nullable = false)
    private String modifiedBy; // 제목

    protected Article() {}

    private Article(String title, String content, String hashtags) {

        this.title = title;
        this.content = content;
        this.hashtags = hashtags;
    }

    public static Article of (String title, String content, String hashtags) {
        return new Article(title,content, hashtags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
