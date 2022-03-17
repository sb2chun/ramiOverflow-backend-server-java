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
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class QuestionListResponse {

    @ApiModelProperty(value = "질문 id", example = "1", position = 1)
    private Long questionId;
    @ApiModelProperty(value = "질문 제목", example = "what's the better between ...", position = 2)
    private String title;
    @ApiModelProperty(value = "점수", example = "10", position = 3)
    private Integer score;
    @ApiModelProperty(value = "태그", example = "java;c#", position = 4)
    private String tags;
    @ApiModelProperty(value = "답변 수", example = "0", position = 5)
    private Integer AnswerCount;
    @ApiModelProperty(value = "조회 수", example = "0", position = 6)
    private Integer viewCount;
    @ApiModelProperty(value = "답변 여부", example = "false", position = 7)
    private Boolean isAnswered;
    @ApiModelProperty(value = "질문 링크", example = "http://www.ramioverflow.com/11", position = 8)
    private String link;
    @ApiModelProperty(value = "최초 생성 일시", example = "2022-02-02'T'10:43:52", position = 9)
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "최종 수정 일시", example = "2022-02-02'T'10:43:52", position = 10)
    private LocalDateTime lastEditedAt;

    public static QuestionListResponse fromEntity(Post entity) {
        QuestionListResponse response = new QuestionListResponse();

        response.setQuestionId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setScore(entity.getScore());
        response.setTags(entity.getTags());
        response.setAnswerCount(entity.getAnswerCount());
        response.setViewCount(entity.getViewCount());
        response.setIsAnswered(response.getAnswerCount() > 0);
        response.setLink(SysConfig.QUESTION_DEFAULT_URL + entity.getId());
        response.setCreatedAt(entity.getCreatedAt());
        response.setLastEditedAt(entity.getLastEditedAt());

        return response;
    }
}
