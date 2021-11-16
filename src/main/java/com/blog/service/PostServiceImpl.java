package com.blog.service;

import com.blog.data.model.Post;
import com.blog.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    Post post1 = new Post();

    @Override
    public Post addPost(PostDto postDto) {
        post1.setTitle(postDto.getTitle());
        post1.setBody(postDto.getBody());
        post1.setImageUrl(postDto.getImageUrl());
        post1.setDateOfPost(postDto.getDateOfPost());
        return postRepository.save(post1);
    }

    @Override
    public Optional<Post> findByPostId(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
