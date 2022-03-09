package com.miracom.backendramioverflow.posts.entity.posts;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 3)
    private Integer postId;

    @Column(length = 10)
    private Integer score;

    @Column(length = 800)
    private String text;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(length = 30)
    private String userId;

    @Column(length = 40)
    private String userName;

    @Column
    private Boolean useYn;

    @Column
    private Boolean delYn;

}
