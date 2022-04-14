package com.miracom.backendramioverflow.posts.repository;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Post, Long> {
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Post p set p.parentId=?1 where p.id=?2")
    public int acceptAnswerById(long id, Long acceptedId);
}
