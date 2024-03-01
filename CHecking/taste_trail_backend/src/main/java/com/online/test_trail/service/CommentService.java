package com.online.test_trail.service;


import com.online.test_trail.dto.CommentDto;
import com.online.test_trail.entity.Comment;

import java.util.List;

public interface CommentService {
    void save(CommentDto commentDto);

    List<Comment> getCommentByContentId(Long content_id);

    void deleteById(Long id);

    List<Comment> getAllComments();
}
