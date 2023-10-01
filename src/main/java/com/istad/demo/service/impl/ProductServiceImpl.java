package com.istad.demo.service.impl;

import com.istad.demo.model.Product;
import com.istad.demo.repository.ProductRepository;
import com.istad.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> loadProducts() {
        return productRepository.selectProducts();
    }

    @Override
    public Product loadProductById(Integer id) {
        return productRepository.selectProductById(id).orElseThrow();
    }
    @Override
    public void createNewProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public void updateProductById(Integer id, Product product) {
        productRepository.updateProduct(id, product);
    }


}
