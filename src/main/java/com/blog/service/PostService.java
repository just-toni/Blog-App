package com.blog.service;

import com.blog.data.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    Post addPost(PostDto postDto);
    Optional<Post> findByPostId(Long postId);
    void deletePostById(Long postId);
    List<Post> findAll();
    Post addComment(CommentDto commentDto, Long postId);

}
