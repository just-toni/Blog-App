package com.blog.service;

import com.blog.data.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentService {

    Comment addComment(Comment comment);
    Optional<Comment> findByCommentId(Long commentId);
    void deleteCommentById(Long commentId);
    List<Comment> findAll();


}
