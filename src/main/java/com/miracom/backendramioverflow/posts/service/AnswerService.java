package com.miracom.backendramioverflow.posts.service;

import com.miracom.backendramioverflow.posts.dto.response.answer.AnswerDetailResponse;
import com.miracom.backendramioverflow.posts.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {

    private final AnswerRepository answerRepository;

    public int acceptAnswerById(Long id, Long acceptedId) {

        return answerRepository.acceptAnswerById(id, acceptedId);
    }
}
