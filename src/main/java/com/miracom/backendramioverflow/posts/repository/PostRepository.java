package com.miracom.backendramioverflow.posts.repository;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}
