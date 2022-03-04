package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.request.WriteQuestionRequest;
import com.miracom.backendramioverflow.posts.dto.response.QuestionDetailResponse;
import com.miracom.backendramioverflow.posts.dto.response.QuestionListResponse;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.posts.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    //Read List
    public List<QuestionListResponse> findAllQuestion() {
        List<Post> questions = questionRepository.findAllQuestion();

        return questions.stream().map(QuestionListResponse::fromEntity).collect(Collectors.toList());
    }

    //Read One
    public QuestionDetailResponse findQuestionById(long id) {
        Post post = questionRepository.findQuestionById(id);

        return QuestionDetailResponse.fromEntity(post);
    }

    //Create
    public QuestionDetailResponse createQuestion(WriteQuestionRequest request) {
        Post post = request.toEntity();
        post.createQuestion();

        return QuestionDetailResponse.fromEntity(questionRepository.save(post));
    }

    //Delete(update)
    public QuestionDetailResponse deleteQuestionById(long id) {
        Optional<Post> post = questionRepository.findById(id);

        post.ifPresent(selectQuestion -> {
            selectQuestion.deletePost();

            questionRepository.save(selectQuestion);
        });

        return QuestionDetailResponse.fromEntity(post.get());
    }
}
