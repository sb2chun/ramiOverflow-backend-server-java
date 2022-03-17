package com.miracom.backendramioverflow.posts.entity.posts;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 3)
    private Integer postTypeId;     // 1-Question, 2-Answer

    @Column
    private Long acceptAnswerId;  // only present if PostTypeId = 1

    @Column
    private Long parentId;        // only present if PostTypeId = 2

    @Column(length = 10)
    @ColumnDefault("0")
    @NotNull
    private Integer score;

    @Column(length = 10)
    @ColumnDefault("0")
    private Integer viewCount;

    @Column(length = 800)
    private String body;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;        // FST_REG_DT

    @Column(length = 30)
    private String ownerUserId;         // FST_REGER_ID

    @Column(length = 40)
    private String ownerUserName;

    @Column(length = 30)
    private String lastEditorUserId;

    @Column(length = 40)
    private String lastEditorUserName;

    @Column
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @ColumnDefault("false")
    private LocalDateTime lastEditedAt;

    @Column
    private String title;

    @Column
    private String tags;

    @Column(length = 10)
    @ColumnDefault("0")
    private Integer answerCount;

    @Column(length = 10)
    @ColumnDefault("0")
    private Integer favoriteCount;

    @Column(length = 10)
    @ColumnDefault("0")
    private Integer commentCount;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime closedAt;

    @Column
    @ColumnDefault("false")
    private Boolean isClosed;

    @Column
    @ColumnDefault("true")
    private Boolean isUsed;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;

//    @PrePersist
//    public void prePersist() {
//        this.isClosed = false;
//        this.isUsed = true;
//        this.isDeleted = false;
//    }

    public void deletePost() {
        this.isDeleted = true;
        this.isUsed = false;
    }

    public void createQuestion() {
        this.postTypeId = 1;
        this.createdAt = LocalDateTime.now();
    }

    public void createAnswer(Long id) {
        this.parentId = id;
        this.postTypeId = 2;
        this.createdAt = LocalDateTime.now();
    }

    public void updateQuestion(String title, String body) {
        this.title = title;
        this.body = body;
        this.lastEditedAt = LocalDateTime.now();
    }

    public void acceptAnswerId(Long id) {
        this.acceptAnswerId = id;
        this.lastEditedAt = LocalDateTime.now();
    }


}
