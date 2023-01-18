package com.sunitcb.classroom.repo;

import com.sunitcb.classroom.domain.Product;
import com.sunitcb.classroom.domain.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Configuration
public interface ProductRepo {

    List<Product> findAll();
    Product findById();
    void save(Product p);
    void update(int id, Product p);
    void delete(int id);
    Review getReviewByProductId(int id);
}
