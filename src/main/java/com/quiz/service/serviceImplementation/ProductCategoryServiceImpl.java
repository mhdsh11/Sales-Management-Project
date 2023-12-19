package com.quiz.service.serviceImplementation;
import com.quiz.model.ProductCategory;
import com.quiz.repository.ProductCategoryRepository;
import com.quiz.service.serviceInterface.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public List<ProductCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ProductCategory getCategoryById(Integer categoryId) {
        Optional<ProductCategory> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElse(null);
    }

    @Override
    public ProductCategory createCategory(ProductCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public ProductCategory updateCategory(Integer categoryId, ProductCategory updatedCategory) {
        Optional<ProductCategory> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            ProductCategory existingCategory = optionalCategory.get();
            existingCategory.setName(updatedCategory.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
