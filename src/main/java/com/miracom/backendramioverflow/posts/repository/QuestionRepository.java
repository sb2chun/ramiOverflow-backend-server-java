package com.miracom.backendramioverflow.posts.repository;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.isUsed=true")
    public List<Post> findAllQuestion();

    @Query("select p from Post p where p.id=?1 and p.isUsed=true")
    public Post findQuestionById(long id);
}
