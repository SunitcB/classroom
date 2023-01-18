package com.sunitcb.classroom.controller;

import com.sunitcb.classroom.domain.Product;
import com.sunitcb.classroom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/v1/products")
    public List<Product> productList(){
        Product p = new Product();
        return new ArrayList<>();
    }

    @GetMapping("/v2/products")
    public List<Product> productList2(){
        Product p = new Product();
        return new ArrayList<>();
    }
}
