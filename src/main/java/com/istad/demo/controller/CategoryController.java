package com.istad.demo.controller;

import com.istad.demo.model.Category;
import com.istad.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Category> getCategories(){
        return categoryService.loadCategories();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.loadCategoryById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewCategory(@RequestBody Category category){
        categoryService.createNewCategory(category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable("id") Integer id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") Integer id){
        categoryService.deleteCategoryById(id);
    }
}
