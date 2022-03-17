package com.miracom.backendramioverflow.posts.dto.request.question;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class WriteQuestionRequest {

    @ApiModelProperty(value = "제목", example = "How to use Swagger?", position = 1)
    private String title;
    @ApiModelProperty(value = "본문", example = "I want to use swagger in my ...", position = 2)
    private String body;
    @ApiModelProperty(value = "태그", example = "java;swagger", position = 3)
    private String tags;
    @ApiModelProperty(value = "작성자 id", example = " k-dohyun", position = 4)
    private String ownerUserId;
    @ApiModelProperty(value = "작성자 이름", example = "g-dragon", position = 5)
    private String ownerUserName;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .body(this.body)
                .tags(this.tags)
                .ownerUserName(this.ownerUserName)
                .ownerUserId(this.ownerUserId)
                .build();
    }
}
