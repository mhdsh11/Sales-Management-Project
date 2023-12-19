package com.quiz.service.serviceInterface;
import com.quiz.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllCategories();

    ProductCategory getCategoryById(Integer categoryId);

    ProductCategory createCategory(ProductCategory category);

    ProductCategory updateCategory(Integer categoryId, ProductCategory category);

    void deleteCategory(Integer categoryId);
}
