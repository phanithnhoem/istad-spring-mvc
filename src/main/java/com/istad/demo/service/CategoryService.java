package com.istad.demo.service;

import com.istad.demo.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> loadCategories();
    Category loadCategoryById(Integer id);
    void createNewCategory(Category category);
    void updateCategory(Integer id, Category category);
    void deleteCategoryById(Integer id);
}
