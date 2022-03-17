package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.request.answer.WriteNewAnswerRequest;
import com.miracom.backendramioverflow.posts.dto.request.question.UpdateQuestionRequest;
import com.miracom.backendramioverflow.posts.dto.request.question.WriteQuestionRequest;
import com.miracom.backendramioverflow.posts.dto.response.answer.AnswerDetailResponse;
import com.miracom.backendramioverflow.posts.dto.response.question.QuestionDetailResponse;
import com.miracom.backendramioverflow.posts.dto.response.question.QuestionListResponse;
import com.miracom.backendramioverflow.posts.entity.posts.Post;
import com.miracom.backendramioverflow.posts.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
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
    public QuestionDetailResponse findQuestionById(Long id) {
        Post post = questionRepository.findQuestionById(id);

        return QuestionDetailResponse.fromEntity(post);
    }

    //Create
    public QuestionDetailResponse createQuestion(WriteQuestionRequest request) {
        Post post = request.toEntity();
        post.createQuestion();

        questionRepository.save(post);

        return QuestionDetailResponse.fromEntity(post);
    }

    public QuestionDetailResponse deleteQuestionById(Long id) {
        Optional<Post> post = questionRepository.findById(id);
        post.ifPresent(selectQuestion -> {
            selectQuestion.deletePost();

            questionRepository.save(selectQuestion);
            questionRepository.deleteQuestionById(id);
        });

        return QuestionDetailResponse.fromEntity(post.get());
    }

    public QuestionDetailResponse updateQuestionById(Long id, UpdateQuestionRequest request) {
        Optional<Post> post = questionRepository.findById(id);

        post.ifPresent(selectQuestion -> {
            selectQuestion.updateQuestion(request.getTitle(), request.getBody());

            questionRepository.save(selectQuestion);
        });

        return QuestionDetailResponse.fromEntity(post.get());
    }

    public List<QuestionDetailResponse> findAllAnswerByQuestionId(Long id) {
        List<Post> answers = questionRepository.findAllAnswerByQuestionId(id);

        return answers.stream().map(QuestionDetailResponse::fromEntity).collect(Collectors.toList());
    }

    public AnswerDetailResponse addAnswerByQuestionId(Long id, WriteNewAnswerRequest request) {
//        Optional<Post> postOptional = questionRepository.findById(id);
//        if ( BaseUtil.isEqual( postOptional.get().getPostTypeId(), PostTypesEnum.QUESTION)){
//            Post post = request.toEntity();
//            post.createAnswer(id);
//            questionRepository.save(post);
//            return AnswerDetailResponse.fromEntity(post);
//
//        }else{
//            new IllegalArgumentException("해당 글은 질문 글이 아닙니다. id = " + id);
//            return null;
//        }
        Post post = request.toEntity();
        post.createAnswer(id);

        questionRepository.save(post);

        return AnswerDetailResponse.fromEntity(post);
    }
}
