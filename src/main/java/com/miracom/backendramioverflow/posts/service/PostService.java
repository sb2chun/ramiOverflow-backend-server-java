package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.response.PostResponse;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.posts.repository.PostRepository;
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

    public Page<PostResponse> findAllPostWithPage(Pageable pageable) {
        Page<Post> posts = postRepository.findAllPostWithPage(pageable);

        return posts.map(PostResponse::fromEntity);
    }
}
