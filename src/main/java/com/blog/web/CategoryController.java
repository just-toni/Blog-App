package com.blog.web;

import com.blog.data.model.Category;
import com.blog.service.CategoryDto;
import com.blog.service.CategoryService;
import com.blog.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/category/add")
    public Category addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/api/category/{categoryId}")
    public Optional<Category> findByCategoryId(@PathVariable Long categoryId){
        return categoryService.findByCategoryId(categoryId);
    }

    @GetMapping("/api/category/findAll")
    public List<Category> findAllCategories(){
        return categoryService.findAll();
    }

    @DeleteMapping("/api/category/delete/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategoryById(categoryId);
    }

}