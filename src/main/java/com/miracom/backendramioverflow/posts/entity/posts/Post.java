package com.miracom.backendramioverflow.posts.entity.posts;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 3)
    private int postTypeId;     // 1-Question, 2-Answer

    @Column
    private long acceptAnswerId;  // only present if PostTypeId = 1

    @Column
    private long parentId;        // only present if PostTypeId = 2

    @Column(length = 10)
    private int score;

    @Column(length = 10)
    private int viewCount;

    @Column(length = 800)
    private String body;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate createdAt;        // FST_REG_DT

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
    private LocalDate lastEditedAt;

    @Column
    private String title;

    @Column
    private String tags;

    @Column(length = 10)
    private int answerCount;

    @Column(length = 10)
    private int favoriteCount;

    @Column(length = 10)
    private int commentCount;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate closedAt;

    @Column
    private boolean isClosed;

    @Column
    private boolean isUsed;

    @Column
    private boolean isDeleted;

    @PrePersist
    public void prePersist(){
        this.isClosed = false;
        this.isUsed = true;
        this.isDeleted = false;
    }

    public void deletePost(){
        this.isDeleted = true;
        this.isUsed = false;
    }

    public void createQuestion(){
        this.createdAt = LocalDate.now();
        this.postTypeId = 1;
    }

    public void updateQuestion() {
        this.lastEditedAt =LocalDate.now();
    }
}
