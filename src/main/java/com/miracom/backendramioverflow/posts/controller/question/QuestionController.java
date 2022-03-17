package com.miracom.backendramioverflow.posts.controller.question;

import com.miracom.backendramioverflow.posts.dto.request.answer.WriteNewAnswerRequest;
import com.miracom.backendramioverflow.posts.dto.request.question.UpdateQuestionRequest;
import com.miracom.backendramioverflow.posts.dto.request.question.WriteQuestionRequest;
import com.miracom.backendramioverflow.posts.dto.response.answer.AnswerDetailResponse;
import com.miracom.backendramioverflow.posts.dto.response.question.QuestionDetailResponse;
import com.miracom.backendramioverflow.posts.dto.response.question.QuestionListResponse;
import com.miracom.backendramioverflow.posts.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @PostMapping("/add")
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
    public QuestionDetailResponse findQuestionById(@PathVariable Long id) {

        return questionService.findQuestionById(id);
    }

    @ApiOperation(value = "특정 질문 삭제")
    @PatchMapping("/{id}/delete")
    public QuestionDetailResponse deleteQuestionById(@PathVariable Long id) {
//    public int deleteQuestionById(@PathVariable Long id) {

        return questionService.deleteQuestionById(id);
    }

    @ApiOperation(value = "특정 질문 수정")
    @PatchMapping("/{id}/edit")
    public QuestionDetailResponse updateQuestionById(@PathVariable Long id
            , @RequestBody UpdateQuestionRequest request) {

        return questionService.updateQuestionById(id, request);
    }

    @ApiOperation(value = "질문에 대한 새 답변 등록")
    @PostMapping("/{id}/answers/add")
    public AnswerDetailResponse addAnswerByQuestionId(@PathVariable Long id
            , @RequestBody WriteNewAnswerRequest request) {

        return questionService.addAnswerByQuestionId(id, request);
    }

    @ApiOperation(value = "특정 질문에 대한 답변 조회")
    @GetMapping("/{id}/answers")
    public List<QuestionDetailResponse> findAllAnswerByQuestionId(@PathVariable Long id) {

        return questionService.findAllAnswerByQuestionId(id);
    }

}
