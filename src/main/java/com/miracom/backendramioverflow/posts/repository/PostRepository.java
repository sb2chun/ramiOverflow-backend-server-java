package com.miracom.backendramioverflow.posts.repository;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.isUsed=true")
    public Page<Post> findAllPostWithPage(Pageable pageable);
}
