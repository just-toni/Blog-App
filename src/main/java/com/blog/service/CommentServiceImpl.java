package com.blog.service;

import com.blog.data.model.Comment;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    @Override
    public Comment addComment(Comment comment) {
        return null;
    }

    @Override
    public Optional<Comment> findByCommentId(Long commentId) {
        return Optional.empty();
    }

    @Override
    public void deleteCommentById(Long commentId) {

    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
