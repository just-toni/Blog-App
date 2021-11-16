package com.blog.web;

import com.blog.data.model.Comment;
import com.blog.data.model.Post;
import com.blog.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService = new PostServiceImpl();

    @PostMapping("/post/add")
    public Post addPost(@RequestBody PostDto postDto){
        return postService.addPost(postDto);
    }

    @GetMapping("/api/post/{postId}")
    public Optional<Post> findPostById(@PathVariable Long postId){
        return postService.findByPostId(postId);
    }

    @GetMapping("/api/post/findAll")
    public List<Post> findAllPosts(){
        return postService.findAll();
    }

    @DeleteMapping("/api/post/delete/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePostById(postId);
    }

}
