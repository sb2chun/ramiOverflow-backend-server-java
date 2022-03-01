package com.miracom.backendramioverflow.posts.entity.posts;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "POST_TYPE")
public class PostType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 3)
    private int id;     // Posts`s PostTypeId

    @Column(length = 10)
    private String Name;

    @Column
    private boolean useYn;

    @Column
    private boolean delYn;

}
