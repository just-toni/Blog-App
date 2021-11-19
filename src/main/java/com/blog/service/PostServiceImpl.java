package com.blog.service;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import com.blog.data.model.Post;
import com.blog.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
   private PostRepository postRepository;

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

    @Override
    public Post addComment(CommentDto commentDto, Long postId) {
        findByPostId(postId);
        Comment comment =  new Comment();
        comment.setComment(commentDto.getComment());
        comment.setCommenter(commentDto.getCommenter());
        comment.setTime(LocalTime.from(commentDto.getTime()));
        post1.getComments().add(comment);
        return postRepository.save(post1);
    }

}