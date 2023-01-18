package com.sunitcb.classroom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private int id;
    private String name;
    private float price;
    private String category;
    private int discount;
    private int starCount;
    private boolean deleted;
    private LocalDateTime createdAt;
    // ....
    private List<Review> reviews;
    public Product(int id, String name, float price, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reviews = reviews;
    }
}