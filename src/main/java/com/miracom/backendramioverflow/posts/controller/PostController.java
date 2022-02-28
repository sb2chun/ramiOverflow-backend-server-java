package com.miracom.backendramioverflow.posts.controller;

import com.miracom.backendramioverflow.posts.dto.request.PostRequestDTO;
import com.miracom.backendramioverflow.posts.dto.response.PostResponseDTO;
import com.miracom.backendramioverflow.posts.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags= "Post Api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "Post 전체 조회")
    @GetMapping
    public List<PostResponseDTO> findAllPost(){

        return postService.findAllPost();
    }

    @ApiOperation(value = "Post 작성")
    @PostMapping
    public PostResponseDTO savePost(@RequestBody PostRequestDTO params){

        return postService.savePost(params);
    }

}