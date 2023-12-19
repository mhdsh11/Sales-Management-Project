package com.quiz.controller;

import com.quiz.model.ProductCategory;
import com.quiz.service.serviceInterface.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService categoryService;



    @GetMapping
    public List<ProductCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public ProductCategory getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping
    public ProductCategory createCategory(@RequestBody ProductCategory category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{categoryId}")
    public ProductCategory updateCategory(@PathVariable Integer categoryId, @RequestBody ProductCategory category) {
        return categoryService.updateCategory(categoryId, category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
