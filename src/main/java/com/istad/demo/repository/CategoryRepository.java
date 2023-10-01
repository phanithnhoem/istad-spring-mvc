package com.istad.demo.repository;

import com.istad.demo.model.Category;
import com.istad.demo.repository.provider.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface CategoryRepository {
    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategories();

    @Select("SELECT * FROM categories")
    List<Category> selectCategories();

    @Select("SELECT * FROM categories WHERE id = #{id}")
    Optional<Category> selectCategoryById(Integer id);

    @Insert("""
            INSERT INTO categories (name, description) 
            VALUES (#{name}, #{description})
            """)
    void insertCategory(Category category);

    @Update("""
        UPDATE categories 
        SET name = #{name}, description = #{description} 
        WHERE id=#{id}
        """)
    void updateCategory(Integer id, Category category);

    @Select("DELETE FROM categories WHERE id = #{id}")
    void deleteCategory(Integer id);
}
