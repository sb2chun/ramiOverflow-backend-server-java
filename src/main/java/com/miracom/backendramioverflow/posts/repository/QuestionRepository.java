package com.miracom.backendramioverflow.posts.repository;

import com.miracom.backendramioverflow.posts.entity.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.isUsed=true and p.isDeleted=false")
    public List<Post> findAllQuestion();

    @Query("select p from Post p where p.id=?1 and p.isUsed=true and p.isDeleted=false")
    public Post findQuestionById(long id);

    @Query("select p from Post p where p.postTypeId=2 and p.parentId=?1 and p.isUsed=true and p.isDeleted=false")
    public List<Post> findAllAnswerByQuestionId(long id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Post p set p.isUsed = false, isDeleted = true where p.parentId=?1 and p.isUsed=true and p.isDeleted=false")
//    @Query("select p from Post p where (p.id=?1 or p.parentId=?1) and p.isUsed=true and p.isDeleted=false")
    public void deleteQuestionById(long id);

}
