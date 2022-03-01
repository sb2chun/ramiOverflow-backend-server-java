package com.miracom.backendramioverflow.posts.controller;

import com.miracom.backendramioverflow.posts.dto.request.PostRequest;
import com.miracom.backendramioverflow.posts.dto.response.PostResponse;
import com.miracom.backendramioverflow.posts.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags= "Post Api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "Post 작성")
    @PostMapping
    public PostResponse savePost(@RequestBody PostRequest params){

        return postService.savePost(params);
    }

    @ApiOperation(value = "특정 Post 조회")
    @GetMapping("/{id}")
    public PostResponse findPost(@PathVariable @ApiParam(value = "게시판 ID", example = "1") Long id){
        return postService.findPost(id);
    }

    @ApiOperation(value = "Post 전체 조회")
    @GetMapping
    public List<PostResponse> findAllPost(){

        return postService.findAllPost();
    }

    @ApiOperation(value = "특정 Post 삭제")
    @PutMapping("/{id}")
    public PostResponse deletePostById(@PathVariable @ApiParam(value = "게시판 ID", example = "1") Long id){

        return postService.deletePostById(id);
    }
}