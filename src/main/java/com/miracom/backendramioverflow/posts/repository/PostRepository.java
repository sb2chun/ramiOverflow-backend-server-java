package com.miracom.backendramioverflow.posts.repository;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.isUsed=true")
    public List<Post> findAllPost();

    @Query("select p from Post p where p.id = ?1 and p.isUsed=true")
    public Post findPostById(Long id);
}
