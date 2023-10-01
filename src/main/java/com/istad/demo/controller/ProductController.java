package com.istad.demo.controller;

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
    public void createNewProduct(@RequestBody Product product){
        productService.createNewProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Integer id, @RequestBody Product product){
        productService.updateProductById(id, product);
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
