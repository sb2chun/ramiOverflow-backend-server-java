package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.request.PostRequestDTO;
import com.miracom.backendramioverflow.posts.dto.response.PostResponseDTO;
import com.miracom.backendramioverflow.posts.entity.conditions.PostTypesEnum;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDTO> findAllPost() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(PostResponseDTO::fromEntity).collect(Collectors.toList());
    }

    public PostResponseDTO savePost(PostRequestDTO postRequestDTO) {
        Post post = initNewQuestion(postRequestDTO);

        return PostResponseDTO.fromEntity(postRepository.save(post));
    }

    private Post initNewQuestion(PostRequestDTO postRequestDTO) {
        postRequestDTO.setPostTypeId(PostTypesEnum.QUESTION.value());

        return postRequestDTO.toEntity();
    }
}
