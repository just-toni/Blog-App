package com.blog.web;

import com.blog.data.model.Comment;
import com.blog.service.CommentDto;
import com.blog.service.CommentService;
import com.blog.service.CommentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CommentController {

    private final CommentService commentService = new CommentServiceImpl();

    @PostMapping("/api/addComment")
    public Comment addComment(CommentDto commentDto){
        return commentService.addComment(commentDto);
    }

    @GetMapping("/api/comment/{commentId}")
    public Optional<Comment> findCommentById(@PathVariable Long commentId){
        return commentService.findByCommentId(commentId);
    }



}