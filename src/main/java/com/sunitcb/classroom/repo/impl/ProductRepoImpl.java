package com.sunitcb.classroom.repo.impl;

import com.sunitcb.classroom.domain.Product;
import com.sunitcb.classroom.domain.Review;
import com.sunitcb.classroom.repo.ProductRepo;

import java.util.List;

public class ProductRepoImpl implements ProductRepo {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById() {
        return null;
    }

    @Override
    public void save(Product p) {

    }

    @Override
    public void update(int id, Product p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Review getReviewByProductId(int id) {
        return null;
    }
}
