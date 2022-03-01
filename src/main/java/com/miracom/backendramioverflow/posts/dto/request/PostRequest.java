package com.miracom.backendramioverflow.posts.dto.request;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class PostRequest {
    @ApiModelProperty(value = "제목", example = "How to use Swagger...", position = 13)
    private String title;

    @ApiModelProperty(value = "본문", example = "Hello, I'm ...", position = 6)
    private String body;

    @ApiModelProperty(value = "태그", example = "???", position = 14)
    private String tags;

    @ApiModelProperty(value = "유저 ID", example = "k-dohyun", position = 8)
    private String ownerUserId;         // FST_REGER_ID

    @ApiModelProperty(value = "유저 이름", example = "쥐드래곤", position = 9)
    private String ownerUserName;

    @ApiModelProperty(value = "게시글 Type", example = "1", position = 1)
    private int postTypeId;     // 1-Question, 2-Answer



    public Post toEntity(){
        return Post.builder()
                .title(this.title)
                .body(this.body)
                .tags(this.tags)
                .postTypeId(this.postTypeId)
                .ownerUserId(this.ownerUserId)
                .ownerUserName(this.ownerUserName)
                .build();
    }


}
