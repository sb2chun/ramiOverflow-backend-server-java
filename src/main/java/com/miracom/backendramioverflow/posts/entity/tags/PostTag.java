package com.miracom.backendramioverflow.posts.entity.tags;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(PostTagPK.class)
@Table(name = "POST_TAG")
public class PostTag {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagId;
}
