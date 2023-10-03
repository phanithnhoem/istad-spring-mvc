package com.istad.demo.service.impl;

import com.istad.demo.dto.CreateProductDto;
import com.istad.demo.dto.UpdateProductDto;
import com.istad.demo.model.Category;
import com.istad.demo.model.Product;
import com.istad.demo.model.Supplier;
import com.istad.demo.repository.ProductRepository;
import com.istad.demo.service.ProductService;
import com.istad.demo.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Transactional
    @Override
    public void createNewProduct(CreateProductDto createProductDto) {
        // Map DTO pattern to POJO pattern
        Product product = Product.builder()
                .name(createProductDto.name())
                .slug(SlugUtil.toSlug(createProductDto.name()))
                .description(createProductDto.description())
                .price(createProductDto.price())
                .inStock(createProductDto.inStock())
                .supplier(Supplier.builder()
                        .id(createProductDto.supplierId())
                        .build())
                .build();

        // Start insert data to products table
        productRepository.insertProduct(product);
        System.out.println("Insert product id: " + product.getId() );
        // Start insert data to table products_categories
        createProductDto.categoryIds()
                .forEach(id -> productRepository.insertProductCategories(product.getId(), id));
    }
    @Transactional
    @Override
    public void updateProductInStock(Integer proId, UpdateProductDto updateProductDto) {
        Optional<Product> product = productRepository.selectProductById(proId);
        if (product.isPresent()){
            Product productUpdate = product.get();
            productUpdate = Product.builder()
                            .name(updateProductDto.name())
                            .slug(SlugUtil.toSlug(updateProductDto.name()))
                            .description(updateProductDto.description())
                            .price(updateProductDto.price())
                            .inStock(updateProductDto.inStock())
                            .supplier(Supplier.builder()
                                    .id(updateProductDto.supplierId())
                                    .build())
                            .build();
            // Start update (in_stock, supplier_id)
            productRepository.updateProductInStock(proId, productUpdate);

            // Start update list of categories by id
//            updateProductDto.categoryIds()
//                    .forEach(id -> productRepository.updateProductCategories(proId, id));
        }else {
            System.out.println("Product with id "+ proId +" not found...");
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteProduct(id);
    }

}
