package com.online.test_trail.service.impl;

import com.online.test_trail.dto.CommentDto;
import com.online.test_trail.entity.Comment;
import com.online.test_trail.entity.Content;
import com.online.test_trail.entity.UserEntity;
import com.online.test_trail.repo.CommentRepo;
import com.online.test_trail.repo.ContentRepo;
import com.online.test_trail.repo.UserRepo;
import com.online.test_trail.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final UserRepo userRepo;
    private final ContentRepo contentRepo;

    @Override
    public void save(CommentDto commentDto) {
        Comment comment;

        if (commentDto.getId() != null) {
            comment = commentRepo.findById(commentDto.getId()).get();
        } else {
            comment = new Comment();
        }

        Content content = contentRepo.findById(commentDto.getContentId()).get();
        UserEntity user = userRepo.findById(commentDto.getUserId()).get();


        comment.setContent(content);
        comment.setUserId(user);
        comment.setDescription(commentDto.getDescription());

        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getCommentByContentId(Long content_id) {
        return commentRepo.findCommentByContent_Id(content_id);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }

}
