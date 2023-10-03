package com.istad.demo.service;

import com.istad.demo.dto.CreateProductDto;
import com.istad.demo.dto.UpdateProductDto;
import com.istad.demo.model.Product;
import com.istad.demo.util.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface ProductService {
    List<Product> loadProducts();
    Product loadProductById(Integer id);
    void createNewProduct(CreateProductDto createProductDto);
    void updateProductInStock(Integer id, UpdateProductDto updateProductDto);
    void deleteProductById(Integer id);
}