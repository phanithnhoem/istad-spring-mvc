package com.istad.demo.repository;

import com.istad.demo.model.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductRepository {

    @Select("SELECT * FROM products")
    @Results(id = "productResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "inStock", column = "in_stock"),
            @Result(property = "categories", column = "id",
                many = @Many(select = "com.istad.demo.repository.CategoryRepository.selectProductCategories")),
            @Result(property = "supplier", column = "supplier_id",
                one = @One(select = "com.istad.demo.repository.SupplierRepository.selectProductSupplier"))
    })
    List<Product> selectProducts();

    @Select("SELECT * FROM products WHERE id = #{id}")
    @ResultMap("productResultMap")
    Optional<Product> selectProductById(@Param("id") Integer id);

    @Insert("""
            INSERT INTO products (name, slug, description, price, in_stock, supplier_id)
            VALUES (#{name}, #{slug}, #{description}, #{price}, #{inStock}, supplier_id = #{supplier.id});
            """)
    @ResultMap("productResultMap")
    void insertProduct(Product product);

    @Update("""
            UPDATE products
            SET  name = #{name}, slug = #{slug}, description = #{description}, price = #{price}, in_stock = #{inStock}, supplier_id = #{supplier.id}
            WHERE id = #{id};
           """)
    @ResultMap("productResultMap")
    void updateProduct(Integer id, Product product);

    @Delete("DELETE FROM products WHERE id = #{id}")
    void deleteProduct(Integer id);

}
