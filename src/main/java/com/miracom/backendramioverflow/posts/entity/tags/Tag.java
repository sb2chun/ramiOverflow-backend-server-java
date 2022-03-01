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
    private int count;

    @Column
    private boolean useYn;

    @Column
    private boolean delYn;
}
