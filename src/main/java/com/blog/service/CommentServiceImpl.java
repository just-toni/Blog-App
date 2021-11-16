package com.blog.service;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import com.blog.data.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    Comment comment = new Comment();

    @Override
    public Comment addComment(CommentDto commentDto) {
        comment.setComment(commentDto.getComment());
        comment.setCommenter(commentDto.getCommenter());
        comment.setTime(LocalTime.from(commentDto.getTime()));
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findByCommentId(Long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Category> findAllCategoryById(Long commentId) {
        return null;
    }
}
