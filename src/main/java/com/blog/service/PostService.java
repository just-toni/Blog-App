package com.blog.service;

import com.blog.data.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    Post addPost(Post post);
    Optional<Post> findByPostId(Long postId);
    void deletePostById(Long commentId);
    List<Post> findAll();


}
