package com.miracom.backendramioverflow.posts.dto.response.question;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.miracom.backendramioverflow.config.SysConfig;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDetailResponse {

    @ApiModelProperty(value = "질문 id", example = "1", position = 1)
    private Long questionId;
    @ApiModelProperty(value = "질문 제목", example = "how to use QueryDSL in JPA", position = 2)
    private String title;
    @ApiModelProperty(value = "질문 내용", example = "Hi, I'm new in JPA, and ....", position = 3)
    private String body;
    @ApiModelProperty(value = "점수", example = "10", position = 4)
    private Integer score;
    @ApiModelProperty(value = "태그", example = "JPA;QueryDSL;Java", position = 5)
    private String tags;
    @ApiModelProperty(value = "답변 수", example = "2", position = 6)
    private Integer AnswerCount;
    @ApiModelProperty(value = "조회 수", example = "32", position = 7)
    private Integer viewCount;
    @ApiModelProperty(value = "답변 여부", example = "true", position = 8)
    private Boolean isAnswered;
    @ApiModelProperty(value = "질문 링크", example = "https://www.ramioverflow.com/questions/1", position = 9)
    private String link;
    @ApiModelProperty(value = "최초 생성 일시", example = "2022-02-02'T'10:43:52", position = 10)
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "최종 수정 일시", example = "2022-02-03'T'11:00:01", position = 11)
    private LocalDateTime lastEditedAt;
    @ApiModelProperty(value = "사용 여부", example = "true", position = 13)
    private Boolean isUsed;
    @ApiModelProperty(value = "삭제 여부", example = "false", position = 14)
    private Boolean isDeleted;


    public static QuestionDetailResponse fromEntity(Post entity) {
        QuestionDetailResponse response = new QuestionDetailResponse();

        response.setQuestionId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setBody(entity.getBody());
        response.setScore(entity.getScore());
        response.setTags(entity.getTags());
        response.setAnswerCount(entity.getAnswerCount());
        response.setViewCount(entity.getViewCount());
        response.setIsAnswered(response.getAnswerCount() > 0);
        response.setLink(SysConfig.QUESTION_DEFAULT_URL + entity.getId());
        response.setCreatedAt(entity.getCreatedAt());
        response.setLastEditedAt(entity.getLastEditedAt());
        response.setIsUsed(entity.getIsUsed());
        response.setIsDeleted(entity.getIsDeleted());

        return response;
    }
}