package com.miracom.backendramioverflow.posts.dto.request.answer;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class WriteNewAnswerRequest {

    @ApiModelProperty(value = "본문", example = "I want to use swagger in my ...", position = 1)
    private String body;
    @ApiModelProperty(value = "작성자 id", example = " k-dohyun", position = 2)
    private String ownerUserId;
    @ApiModelProperty(value = "작성자 이름", example = "g-dragon", position = 3)
    private String ownerUserName;

    public Post toEntity() {
        return Post.builder()
                .body(this.body)
                .ownerUserName(this.ownerUserName)
                .ownerUserId(this.ownerUserId)
                .build();
    }
}
