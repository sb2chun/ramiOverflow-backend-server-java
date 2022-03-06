package com.miracom.backendramioverflow.posts.dto.response;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@ApiModel
@Data
@NoArgsConstructor
public class PostResponse {
    @ApiModelProperty(value = "게시글 Type", example = "1", position = 1)
    private int postTypeId;     // 1-Question, 2-Answer

    @ApiModelProperty(value = "채택된 답변의 게시글 Id", example = "3bf02478-491b...", position = 2)
    private String acceptAnswerId;  // only present if PostTypeId = 1

    @ApiModelProperty(value = "부모 게시글 Id", example = "3bf02478-491b...", position = 3)
    private String parentId;        // only present if PostTypeId = 2

    @ApiModelProperty(value = "점수", example = "99", position = 4)
    private int score;

    @ApiModelProperty(value = "조회 수", example = "32", position = 5)
    private int viewCount;

    @ApiModelProperty(value = "본문", example = "Hello, I'm ...", position = 6)
    private String body;

    @ApiModelProperty(value = "생성일시", example = "2022-02-02'T'10:43:52", position = 7)
    private LocalDate createdAt;        // FST_REG_DT

    @ApiModelProperty(value = "유저 ID", example = "k-dohyun", position = 8)
    private String ownerUserId;         // FST_REGER_ID

    @ApiModelProperty(value = "유저 이름", example = "쥐드래곤", position = 9)
    private String ownerUserName;

    @ApiModelProperty(value = "최종 수정자 Id", example = "sb2chun", position = 10)
    private String lastEditorUserId;

    @ApiModelProperty(value = "최종 수정자 이름", example = "천승범", position = 11)
    private String lastEditorUserName;

    @ApiModelProperty(value = "최종 수정일시", example = "2022-02-02'T'10:43:52", position = 12)
    private LocalDate lastEditedAt;

    @ApiModelProperty(value = "제목", example = "How to use Swagger...", position = 13)
    private String title;

    @ApiModelProperty(value = "태그", example = "???", position = 14)
    private String tags;

    @ApiModelProperty(value = "답변 수", example = "32", position = 15)
    private int answerCount;

    @ApiModelProperty(value = "좋아요 수", example = "15", position = 16)
    private int favoriteCount;

    @ApiModelProperty(value = "코멘트 수", example = "3", position = 17)
    private int commentCount;

    @ApiModelProperty(value = "질문 종료 일시", example = "2022-02-02'T'10:43:52", position = 16)
    private LocalDate closedAt;

    @ApiModelProperty(value = "질문 종료 여부", example = "0", position = 17)
    private boolean closeYn;

    @ApiModelProperty(value = "사용 여부", example = "1", position = 18)
    private boolean isUsed;

    @ApiModelProperty(value = "삭제 여부", example = "0", position = 19)
    private boolean isDeleted;

    public static PostResponse fromEntity(Post entity){
        PostResponse postResponseDTO = new PostResponse();

        postResponseDTO.setPostTypeId(entity.getPostTypeId());
        postResponseDTO.setAcceptAnswerId(entity.getAcceptAnswerId());
        postResponseDTO.setParentId(entity.getParentId());
        postResponseDTO.setScore(entity.getScore());
        postResponseDTO.setViewCount(entity.getViewCount());
        postResponseDTO.setBody(entity.getBody());
        postResponseDTO.setCreatedAt(entity.getCreatedAt());
        postResponseDTO.setOwnerUserId(entity.getOwnerUserId());
        postResponseDTO.setOwnerUserName(entity.getOwnerUserName());
        postResponseDTO.setLastEditorUserId(entity.getLastEditorUserId());
        postResponseDTO.setLastEditorUserName(entity.getLastEditorUserName());
        postResponseDTO.setLastEditedAt(entity.getLastEditedAt());
        postResponseDTO.setTitle(entity.getTitle());
        postResponseDTO.setTags(entity.getTags());
        postResponseDTO.setAnswerCount(entity.getAnswerCount());
        postResponseDTO.setFavoriteCount(entity.getFavoriteCount());
        postResponseDTO.setCommentCount(entity.getCommentCount());
        postResponseDTO.setClosedAt(entity.getClosedAt());
        postResponseDTO.setCloseYn(entity.isClosed());
        postResponseDTO.setUsed(entity.isUsed());
        postResponseDTO.setDeleted(entity.isDeleted());

        return postResponseDTO;
    }
}
