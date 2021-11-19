package com.blog.service;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import com.blog.data.model.Post;
import com.blog.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    Category category1 = new Category();

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        category1.setName(categoryDto.getName());
        return categoryRepository.save(category1);
    }

    @Override
    public Optional<Category> findByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addPost(PostDto postDto, Long categoryId) {
        findByCategoryId(categoryId);
        Post post1 = new Post();
        post1.setTitle(postDto.getTitle());
        post1.setBody(postDto.getBody());
        post1.setImageUrl(postDto.getImageUrl());
        post1.setDateOfPost(postDto.getDateOfPost());
        category1.getPosts().add(post1);
        return categoryRepository.save(category1);
    }

    @Override
    public Category addComment(CommentDto commentDto, Long categoryId) {
        findByCategoryId(categoryId);
        Comment comment =  new Comment();
        comment.setComment(commentDto.getComment());
        comment.setCommenter(commentDto.getCommenter());
        comment.setTime(LocalTime.from(commentDto.getTime()));
        category1.getComments().add(comment);
        return categoryRepository.save(category1);
    }
}