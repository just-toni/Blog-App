package com.blog.service;

import com.blog.data.model.Post;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService{
    @Override
    public Post addPost(Post post) {
        return null;
    }

    @Override
    public Optional<Post> findByPostId(Long postId) {
        return Optional.empty();
    }

    @Override
    public void deletePostById(Long commentId) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }
}
