package com.miracom.backendramioverflow.posts.dto.request.question;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@ApiModel
@Data
public class UpdateQuestionRequest {

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
    @ApiModelProperty(value = "게시글 Type", example = "1", position = 6)
    private int postTypeId;

    @ApiModelProperty(value = "최종 수정 일시", example = "2022-03-05'T'14:32:55", position = 7)
    private LocalDate lastEditedAt;
    @ApiModelProperty(value = "최종 수정자 Id", example = "sb2chun", position = 8)
    private String lastEditorUserId;
    @ApiModelProperty(value = "최종 수정자 이름", example = "천승범", position = 9)
    private String lastEditorUserName;


    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .body(this.body)
                .tags(this.tags)
                .postTypeId(this.postTypeId)
                .ownerUserName(this.ownerUserName)
                .ownerUserId(this.ownerUserId)
                .lastEditedAt(this.lastEditedAt)
                .lastEditorUserId(this.lastEditorUserId)
                .lastEditorUserName(this.lastEditorUserName)
                .build();
    }
}
