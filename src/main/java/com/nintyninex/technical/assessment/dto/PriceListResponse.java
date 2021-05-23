package com.nintyninex.technical.assessment.dto;

import lombok.Data;

@Data
public class PriceListResponse {
    private int qty;
    private double cost;

    public PriceListResponse(int qty, double cost) {
        this.qty = qty;
        this.cost = cost;
    }
}
