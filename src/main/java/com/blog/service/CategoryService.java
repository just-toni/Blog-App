package com.blog.service;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    Category addCategory(CategoryDto categoryDto);
    Optional<Category> findByCategoryId(Long categoryId);
    void deleteCategoryById(Long categoryId);
    List<Category> findAll();
    Category addPost(PostDto postDto);
    Category addComment(CommentDto commentDto);

}
