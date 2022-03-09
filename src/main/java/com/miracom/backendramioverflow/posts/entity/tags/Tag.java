package com.miracom.backendramioverflow.posts.entity.tags;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30)
    private String tagName;

    @Column(length = 10)
    private Integer count;

    @Column
    private Boolean useYn;

    @Column
    private Boolean delYn;
}
