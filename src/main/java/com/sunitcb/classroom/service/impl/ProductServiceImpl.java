package com.sunitcb.classroom.service.impl;

import com.sunitcb.classroom.repo.PostRepo;
import com.sunitcb.classroom.repo.ProductRepo;
import com.sunitcb.classroom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final PostRepo postRepo;

    @Autowired
    ProductServiceImpl(PostRepo postRepo){
        this.postRepo = postRepo;
    }


}
