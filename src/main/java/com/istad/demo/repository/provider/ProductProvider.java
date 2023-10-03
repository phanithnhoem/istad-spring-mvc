package com.istad.demo.repository.provider;

import com.istad.demo.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class ProductProvider implements ProviderMethodResolver {

    private final String TB_NAME = "products";
    private final String TB_PRODUCTS_CATEGORIES = "products_categories";

    public String insertProduct(){
        return new SQL(){{
            INSERT_INTO(TB_NAME);
            VALUES("name", "#{p.name}");
            VALUES("slug", "#{p.slug}");
            VALUES("description", "#{p.description}");
            VALUES("price", "#{p.price}");
            VALUES("in_stock", "#{p.inStock}");
            VALUES("supplier_id", "#{p.supplier.id}");
        }}.toString();
    }

    public String insertProductCategories(){
        return new SQL() {{
            INSERT_INTO(TB_PRODUCTS_CATEGORIES);
            VALUES("product_id", "#{proId}");
            VALUES("category_id", "#{cateId}");
        }}.toString();
    }

    public String updateProductInStock(){
        return new SQL(){{
            UPDATE(TB_NAME);
            SET("name = #{p.name}");
            SET("slug = #{p.slug}");
            SET("description = #{p.description}");
            SET("price = #{p.price}");
            SET("in_stock = #{p.inStock}");
            SET("supplier_id = #{p.supplier.id}");
            WHERE("id = #{proId}");
        }}.toString();
    }

//    public String updateProductCategories(){
//        return new SQL(){{
//            UPDATE(TB_PRODUCTS_CATEGORIES);
//            SET("product_id = #{proIdId}");
//            SET("category_id = #{cateId}");
//            WHERE("id = #{id}");
//        }}.toString();
//    }

}
