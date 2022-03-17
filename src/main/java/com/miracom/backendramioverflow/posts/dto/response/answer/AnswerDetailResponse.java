package com.miracom.backendramioverflow.posts.dto.response.answer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.miracom.backendramioverflow.config.SysConfig;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.utils.BaseUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel
@Data
@NoArgsConstructor
public class AnswerDetailResponse {

    @ApiModelProperty(value = "질문 id", example = "1", position = 1)
    private Long questionId;
    @ApiModelProperty(value = "답변 id", example = "1", position = 2)
    private Long answerId;
    @ApiModelProperty(value = "답변 내용", example = "It's absolutely ture. but you ...", position = 3)
    private String body;
    @ApiModelProperty(value = "점수", example = "30", position = 4)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Integer score;
    @ApiModelProperty(value = "태그", example = "JPA;QueryDSL;Java", position = 5)
    private String tags;
    @ApiModelProperty(value = "채택 여부", example = "true", position = 6)
    private boolean isAccepted;
    @ApiModelProperty(value = "질문 링크", example = "https://www.ramioverflow.com/questions/1", position = 7)
    private String link;
    @ApiModelProperty(value = "최초 생성 일시", example = "2022-02-02'T'10:43:52", position = 8)
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "최종 수정 일시", example = "2022-02-03'T'11:00:01", position = 9)
    private LocalDateTime lastEditedAt;
    @ApiModelProperty(value = "사용 여부", example = "true", position = 10)
    private Boolean isUsed;
    @ApiModelProperty(value = "삭제 여부", example = "false", position = 11)
    private Boolean isDeleted;


    public static AnswerDetailResponse fromEntity(Post entity) {
        AnswerDetailResponse response = new AnswerDetailResponse();

        response.setQuestionId(entity.getParentId());
        response.setAnswerId(entity.getId());
        response.setBody(entity.getBody());
        response.setScore(entity.getScore());
        response.setTags(entity.getTags());
        response.setAccepted(BaseUtil.isEqual(entity.getAcceptAnswerId(), entity.getId()));
        response.setLink(SysConfig.QUESTION_DEFAULT_URL + entity.getParentId());
        response.setCreatedAt(entity.getCreatedAt());
        response.setLastEditedAt(entity.getLastEditedAt());
        response.setIsUsed(entity.getIsUsed());
        response.setIsDeleted(entity.getIsDeleted());

        return response;
    }
}