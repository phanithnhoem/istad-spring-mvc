package com.istad.demo.repository.provider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider implements ProviderMethodResolver {
    public String selectProductCategories(){
        String TBL_CATEGORY = "categories";
        return new SQL(){{
            SELECT("*");
            FROM(TBL_CATEGORY + " c");
            INNER_JOIN("products_categories pc ON pc.category_id = c.id");
            WHERE("pc.product_id = #{productId}");
        }}.toString();
    }
}
