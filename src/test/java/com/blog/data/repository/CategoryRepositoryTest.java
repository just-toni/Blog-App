package com.blog.data.repository;

import com.blog.data.model.Category;
import com.blog.data.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void createCategory(){
        Category category1 = new Category("Fashion");
        Category category2 = new Category("Food");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        assertNotNull(category1);
        assertNotNull(category2);
    }

    @Test
    void updateCategoryById(){
        Optional<Category> optionalPost = categoryRepository.findById(1L);
        if(optionalPost.isPresent()){
            Category category = optionalPost.get();
            category.setName("Technology");
            categoryRepository.save(category);
            assertEquals("Technology", category.getName());
        }
    }

    @Test
    void deleteCategoryById(){
        Optional<Category> optionalCategory = categoryRepository.findById(2L);
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            categoryRepository.deleteById(category.getCategoryId());
            assertEquals(1, categoryRepository.count());
        }
    }

}