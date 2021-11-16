package com.blog.web;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import com.blog.service.CommentDto;
import com.blog.service.CommentService;
import com.blog.service.CommentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    private final CommentService commentService = new CommentServiceImpl();

    @PostMapping("/comment/add")
    public Comment addComment(@RequestBody CommentDto commentDto){
        return commentService.addComment(commentDto);
    }

    @GetMapping("/api/comment/{commentId}")
    public Optional<Comment> findCommentById(@PathVariable Long commentId){
        return commentService.findByCommentId(commentId);
    }

    @GetMapping("/api/comment/findAll")
    public List<Comment> findAllComments(){
        return commentService.findAll();
    }

    @DeleteMapping("/api/comment/delete/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
    }

    @GetMapping("/api/comment/findAllCategories/{commentId}")
    public List<Category> findAllCategories(@PathVariable Long commentId){
        return commentService.findAllCategoriesById(commentId);
    }

}