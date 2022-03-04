package com.miracom.backendramioverflow.posts.controller;

import com.miracom.backendramioverflow.posts.dto.request.WriteQuestionRequest;
import com.miracom.backendramioverflow.posts.dto.response.QuestionDetailResponse;
import com.miracom.backendramioverflow.posts.dto.response.QuestionListResponse;
import com.miracom.backendramioverflow.posts.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "질문 관련 API")
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @ApiOperation(value = "새 질문 작성")
    @PostMapping
    public QuestionDetailResponse createQuestion(@RequestBody WriteQuestionRequest request) {

        return questionService.createQuestion(request);
    }

    @ApiOperation(value = "전체 질문 조회")
    @GetMapping
    public List<QuestionListResponse> findAllQuestion() {

        return questionService.findAllQuestion();
    }

    @ApiOperation(value = "특정 질문 조회")
    @GetMapping("/{id}")
    public QuestionDetailResponse findQuestionById(@PathVariable @ApiParam(value = "게시판 ID", example = "1") long id) {

        return questionService.findQuestionById(id);
    }

    @ApiOperation(value = "특정 질문 삭제")
    @PutMapping("/{id}/delete")
    public QuestionDetailResponse deleteQuestionById(@PathVariable @ApiParam(value = "게시판 ID", example = "1") Long id) {

        return questionService.deleteQuestionById(id);
    }


}
