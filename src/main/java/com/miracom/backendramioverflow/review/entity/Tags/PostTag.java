package com.miracom.backendramioverflow.review.entity.Tags;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@IdClass(PostTagPK.class)
@Table(name = "POST_TAG")
public class PostTag {

    @Id
    @Column
    private String postId;

    @Id
    @Column
    private String tagId;
}
