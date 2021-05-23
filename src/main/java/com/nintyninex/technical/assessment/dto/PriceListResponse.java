package com.nintyninex.technical.assessment.dto;

import lombok.Data;

/**
 * DTO class for transfer price list response.
 */
@Data
public class PriceListResponse {
    private int qty;
    private double cost;

    public PriceListResponse(int qty, double cost) {
        this.qty = qty;
        this.cost = cost;
    }
}
