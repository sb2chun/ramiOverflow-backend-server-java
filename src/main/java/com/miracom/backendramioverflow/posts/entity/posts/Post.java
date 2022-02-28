package com.miracom.backendramioverflow.posts.entity.posts;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Builder
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 3)
    private int postTypeId;     // 1-Question, 2-Answer

    @Column
    private String acceptAnswerId;  // only present if PostTypeId = 1

    @Column
    private String parentId;        // only present if PostTypeId = 2

    @Column(length = 10)
    private int score;

    @Column(length = 10)
    private int viewCount;

    @Column(length = 800)
    private String body;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;        // FST_REG_DT

    @Column(length = 30)
    private String ownerUserId;         // FST_REGER_ID

    @Column(length = 40)
    private String ownerUserName;

    @Column(length = 30)
    private String lastEditorUserId;

    @Column(length = 40)
    private String lastEditorUserName;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate closedAt;

    @Column
    private boolean closeYn;

    @Column
    private boolean useYn;

    @Column
    private boolean delYn;
}
