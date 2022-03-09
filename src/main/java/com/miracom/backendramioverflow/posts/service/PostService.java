package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.response.PostResponse;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.posts.repository.PostRepository;
import com.miracom.backendramioverflow.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final String TEST_DATA_PATH = "data/post.json";

    public Page<PostResponse> findAllPostWithPage(Pageable pageable) {
        Page<Post> posts = postRepository.findAllPostWithPage(pageable);

        return posts.map(PostResponse::fromEntity);
    }

    public String setupTestData() {
        Post[] posts = FileUtil.readJsonFile(Post[].class, TEST_DATA_PATH);

        for (Post post : posts) {
            postRepository.save(post);
        }
        return "success";
    }
}
