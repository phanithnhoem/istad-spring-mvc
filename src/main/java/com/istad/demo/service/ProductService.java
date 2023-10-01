package com.istad.demo.service;

import com.istad.demo.model.Product;
import com.istad.demo.util.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface ProductService {
    List<Product> loadProducts();
    Product loadProductById(Integer id);
    void createNewProduct(Product product);
    void updateProductById(Integer id, Product product);
    void deleteProductById(Integer id);
}