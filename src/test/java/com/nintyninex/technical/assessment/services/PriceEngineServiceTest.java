package com.nintyninex.technical.assessment.services;

import com.nintyninex.technical.assessment.models.Product;
import com.nintyninex.technical.assessment.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceEngineServiceTest {

    @Autowired
    PriceEngineService priceEngineService;

    @Autowired
    ProductRepository productRepository;

    @Test
    void calculatePriceForOnePenguinEarsCarton() {
        Optional<Product> testProduct = productRepository.getProduct(1);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 5);
        assertEquals(175.0, result);
    }
}