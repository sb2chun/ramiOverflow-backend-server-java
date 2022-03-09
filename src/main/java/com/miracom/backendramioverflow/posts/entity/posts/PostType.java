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
    private Integer id;     // Posts`s PostTypeId

    @Column(length = 10)
    private String Name;

    @Column
    private Boolean useYn;

    @Column
    private Boolean delYn;

}
