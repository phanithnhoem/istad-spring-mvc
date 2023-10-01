package com.istad.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {
    private Integer id;
    private String name;
    private String slug;
    private String description;
    private Double price;
    private Boolean inStock;
    private Supplier supplier;
    private List<Category> categories;

    public Supplier getSupplier(){
        return supplier;
    }
}
