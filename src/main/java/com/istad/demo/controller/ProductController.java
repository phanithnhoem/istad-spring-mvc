package com.istad.demo.controller;

import com.istad.demo.dto.CreateProductDto;
import com.istad.demo.dto.UpdateProductDto;
import com.istad.demo.model.Product;
import com.istad.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Product> getProducts(){
        return productService.loadProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.loadProductById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewProduct(@RequestBody CreateProductDto createProductDto){
        productService.createNewProduct(createProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateProductInStock(@PathVariable("id") Integer id, @RequestBody UpdateProductDto updateProductDto){
        productService.updateProductInStock(id, updateProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
    }

    @PatchMapping
    public String updateProductPartially() {
        return "Update product partially";
    }

}
