package com.blog.service;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import com.blog.data.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CategoryService categoryService;

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
    public List<Category> findAllCategoriesById(Long commentId) {
        return categoryService.findAll().stream().filter(category -> {
            for(Comment comment : category.getComments()){
                return comment.getCategories().equals(commentId);
            }return false;
        }).collect(Collectors.toList());
    }
}
