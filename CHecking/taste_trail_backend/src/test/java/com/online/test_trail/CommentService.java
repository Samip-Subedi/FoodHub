package com.online.test_trail;

import com.online.test_trail.dto.CommentDto;
import com.online.test_trail.entity.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveComment() {
        // Given
        CommentDto commentDto = new CommentDto();
        commentDto.setContent("Test comment");

        // When
        commentService.save(commentDto);

        // Then
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    public void testGetCommentsByContentId() {
        // Given
        Long contentId = 1L;
        List<Comment> comments = new ArrayList<>();
        // Add some sample comments to the list

        when(commentRepository.findByContentId(contentId)).thenReturn(comments);

        // When
        List<Comment> resultComments = commentService.getCommentByContentId(contentId);

        // Then
        assertEquals(comments, resultComments);
    }

    @Test
    public void testDeleteCommentById() {
        // Given
        Long commentId = 1L;

        // When
        commentService.deleteById(commentId);

        // Then
        verify(commentRepository, times(1)).deleteById(commentId);
    }

    @Test
    public void testGetAllComments() {
        // Given
        List<Comment> comments = new ArrayList<>();
        // Add some sample comments to the list

        when(commentRepository.findAll()).thenReturn(comments);

        // When
        List<Comment> resultComments = commentService.getAllComments();

        // Then
        assertEquals(comments, resultComments);
    }
}
