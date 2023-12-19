package com.quiz.service.serviceInterface;
import com.quiz.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Integer productId);

    Product createProduct(Product product);

    Product updateProduct(Integer productId, Product product);
}
