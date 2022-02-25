package com.miracom.backendramioverflow.posts.entity.Posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Table(name = "COMMENT")
public class Comment {

    private Comment() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Column(length = 3)
    private int postId;

    @Column(length = 10)
    private int score;

    @Column(length = 800)
    private String text;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @Column(length = 30)
    private String userId;

    @Column(length = 40)
    private String userName;

    @Column
    private boolean useYn;

    @Column
    private boolean delYn;
}
