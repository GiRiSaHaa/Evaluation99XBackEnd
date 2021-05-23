package com.nintyninex.technical.assessment.models;

import lombok.Data;

/**
 * Model class for represent product object.
 */
@Data
public class Product {
    private long id;
    private String name;
    private int unitPerCarton;
    private double cartonPrice;
}
