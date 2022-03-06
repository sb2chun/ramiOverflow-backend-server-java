package com.miracom.backendramioverflow.posts.dto.request.answer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@ApiModel
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDetailResponse {

    @ApiModelProperty(value = "질문 id", example = "1", position = 1)
    private long questionId;
    @ApiModelProperty(value = "답변 id", example = "2", position = 2)
    private long answerId;
    @ApiModelProperty(value = "채택 여부", example = "false", position = 3)
    private boolean isAccepted;
    @ApiModelProperty(value = "답변 내용", example = "Hello, In my opinion ...", position = 4)
    private String body;
    @ApiModelProperty(value = "점수", example = "3", position = 5)
    private int score;
    @ApiModelProperty(value = "최초 생성 일시", example = "2022-02-02'T'10:43:52", position = 6)
    private LocalDate createdAt;
    @ApiModelProperty(value = "최종 수정 일시", example = "2022-02-03'T'11:00:01", position = 7)
    private LocalDate lastEditedAt;
    @ApiModelProperty(value = "사용 여부", example = "true", position = 8)
    private boolean isUsed;
    @ApiModelProperty(value = "삭제 여부", example = "false", position = 9)
    private boolean isDeleted;

    public static AnswerDetailResponse fromEntity(Post entity) {
        AnswerDetailResponse response = new AnswerDetailResponse();

        response.setQuestionId(entity.getParentId());
        response.setAnswerId(entity.getId());
        response.setAccepted(entity.getAcceptAnswerId() == entity.getId() ? true : false);
        response.setBody(entity.getBody());
        response.setScore(entity.getScore());
        response.setCreatedAt(entity.getCreatedAt());
        response.setLastEditedAt(entity.getLastEditedAt());
        response.setUsed(entity.isUsed());
        response.setDeleted(entity.isDeleted());

        return response;
    }
}