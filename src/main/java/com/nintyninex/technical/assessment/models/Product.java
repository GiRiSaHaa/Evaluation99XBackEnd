package com.nintyninex.technical.assessment.models;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String name;
    private int unitPerCarton;
    private double cartonPrice;

    public Product() {}
}
