package com.istad.demo.service.impl;

import com.istad.demo.model.Category;
import com.istad.demo.repository.CategoryRepository;
import com.istad.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> loadCategories() {
        return categoryRepository.selectCategories();
    }

    @Override
    public Category loadCategoryById(Integer id) {
        return categoryRepository.selectCategoryById(id).orElseThrow();
    }

    @Override
    public void createNewCategory(Category category) {
        categoryRepository.insertCategory(category);
    }

    @Override
    public void updateCategory(Integer id, Category category) {
        categoryRepository.updateCategory(id, category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteCategory(id);
    }
}
