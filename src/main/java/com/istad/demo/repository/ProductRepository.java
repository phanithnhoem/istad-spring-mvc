package com.istad.demo.repository;

import com.istad.demo.model.Product;
import com.istad.demo.repository.provider.ProductProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductRepository {

    @Select("SELECT * FROM products ORDER BY id DESC")
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


    @InsertProvider(ProductProvider.class)
    // Get ID that has been generated primary key from table and set this id to property object automatically
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertProduct(@Param("p") Product product);

    @InsertProvider(ProductProvider.class)
    void insertProductCategories(@Param("proId") Integer productId,  @Param("cateId") Integer categoryId);


    @UpdateProvider(ProductProvider.class)
    void updateProductInStock(@Param("proId") Integer id, @Param("p") Product product);

//    @UpdateProvider(ProductProvider.class)
//    void updateProductCategories(@Param("proId") Integer id, @Param("cateId") Integer categoryId);

    @Delete("DELETE FROM products WHERE id = #{id}")
    void deleteProduct(Integer id);

}
