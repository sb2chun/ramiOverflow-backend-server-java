package com.miracom.backendramioverflow.posts.controller.answer;

import com.miracom.backendramioverflow.posts.dto.response.answer.AnswerDetailResponse;
import com.miracom.backendramioverflow.posts.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "대답 관련 API")
@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @ApiOperation(value = "특정 대답 채택")
    @PatchMapping("/{id}/accept/{acceptedId}")
    public int acceptAnswerById(@PathVariable Long id
                                                ,@PathVariable Long acceptedId) {

        return answerService.acceptAnswerById(id, acceptedId);
    }
}
