package com.miracom.backendramioverflow.review.entity.Tags;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "TAG")
public class Tag {

    private Tag(){
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Column(length = 30)
    private String tagName;

    @Column(length = 10)
    private int count;

    @Column
    private boolean useYn;

    @Column
    private boolean delYn;
}
