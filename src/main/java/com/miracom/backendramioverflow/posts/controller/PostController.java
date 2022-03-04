package com.miracom.backendramioverflow.posts.controller;

import com.miracom.backendramioverflow.posts.dto.response.PostResponse;
import com.miracom.backendramioverflow.posts.service.PostService;
import com.miracom.backendramioverflow.utils.BaseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "Post Api")
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "전체 Post 조회(페이징)")
    @GetMapping("/page")
    public Page<PostResponse> findAllPostWithPage(@RequestParam(value = "page", required = false, defaultValue = "0") int page
            , @RequestParam(value = "size", required = false, defaultValue = "10") int size
            , @RequestParam(value = "sort", required = false, defaultValue = "id") String column
            , @RequestParam(value = "order", required = false, defaultValue = "desc") String order) {

        PageRequest pageRequest = PageRequest.of(page, size, BaseUtil.sortByColumn(column, order));

        return postService.findAllPostWithPage(pageRequest);
    }
}