package com.blog.service;

import com.blog.data.model.Category;
import com.blog.data.model.Comment;
import com.blog.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public Category addPost(PostDto postDto) {
//        Optional<Post> post = postRepository.findById ( addCommentRequest.getId () );
//        if (post.isEmpty ()) throw new BlogException ( "Post does not exist" );
//        Comment comment = ModelMapper.map ( addCommentRequest );
//        comment = commentRepository.save ( comment );
//        Post updatedPost = post.get ();
//        updatedPost.getComments ().add ( comment );
//        postRepository.save ( updatedPost);

    }
}
