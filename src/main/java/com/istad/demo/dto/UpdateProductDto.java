package com.istad.demo.dto;

import java.util.List;

public record UpdateProductDto(String name,
                               String description,
                               Double price,
                               Boolean inStock,
                               Integer supplierId) {
}
