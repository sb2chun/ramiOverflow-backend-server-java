package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.request.PostRequest;
import com.miracom.backendramioverflow.posts.dto.response.PostResponse;
import com.miracom.backendramioverflow.posts.entity.conditions.PostTypesEnum;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostResponse savePost(PostRequest postRequest) {
        Post post = initNewQuestion(postRequest);

        return PostResponse.fromEntity(postRepository.save(post));
    }

    public PostResponse findPost(Long id){
        Post post = postRepository.findPostById(id);

        return PostResponse.fromEntity(post);
    }


    public List<PostResponse> findAllPost() {
        List<Post> posts = postRepository.findAllPost();

        return posts.stream().map(PostResponse::fromEntity).collect(Collectors.toList());
    }

    private Post initNewQuestion(PostRequest postRequest) {
        postRequest.setPostTypeId(PostTypesEnum.QUESTION.value());

        return postRequest.toEntity();
    }

    public PostResponse deletePostById(Long id){
        Optional<Post> post = postRepository.findById(id);

        post.ifPresent(selectPost ->{
            selectPost.deletePost();

            postRepository.save(selectPost);
        });

        return PostResponse.fromEntity(post.get());
    }
}
