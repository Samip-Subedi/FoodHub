package com.online.test_trail.repo;

import com.online.test_trail.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {


    @Query(value = "select * from comment where content_id=?1",nativeQuery = true)
    List<Comment> findCommentByContent_Id(Long content);
}

