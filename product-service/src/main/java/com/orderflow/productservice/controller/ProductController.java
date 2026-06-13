package com.orderflow.productservice.controller;

import com.orderflow.productservice.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts() {
        return Arrays.asList(
                new ProductDto(1L, "Laptop", 999.99, 10),
                new ProductDto(2L, "Mouse", 19.99, 50),
                new ProductDto(3L, "Keyboard", 49.99, 30)
        );
    }
}