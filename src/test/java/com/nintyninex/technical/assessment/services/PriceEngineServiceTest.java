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
    void calculatePriceForSingleUnitPenguinEars() {
        Optional<Product> penguinEars = productRepository.getProduct(1);
        if(penguinEars.isPresent()){
            double result = priceEngineService.calculatePrice(penguinEars.get().getId(), 1);
            assertEquals(11.38, result);
        }
    }

    @Test
    void calculatePriceForSingleUnitHorseshoe() {
        Optional<Product> testProduct = productRepository.getProduct(2);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 1);
        assertEquals(214.5, result);
    }

    @Test
    void calculatePriceForOnePenguinEarsCarton() {
        Optional<Product> testProduct = productRepository.getProduct(1);
        if(testProduct.isPresent()){
            double result = priceEngineService.calculatePrice(testProduct.get().getId(), 20);
            assertEquals(175.0, result);
        }
    }

    @Test
    void calculatePriceForOneHorseshoeCarton() {
        Optional<Product> testProduct = productRepository.getProduct(2);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 5);
        assertEquals(825.0, result);
    }

    @Test
    void calculatePriceFor19PenguinEarsUnits() {
        Optional<Product> testProduct = productRepository.getProduct(1);
        if(testProduct.isPresent()){
            double result = priceEngineService.calculatePrice(testProduct.get().getId(), 19);
            assertEquals(216.13, result);
        }
    }

    @Test
    void calculatePriceFor4HorseshoeUnits() {
        Optional<Product> testProduct = productRepository.getProduct(2);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 4);
        assertEquals(858, result);
    }

    @Test
    void calculatePriceForThreePenguinEarsCarton() {
        Optional<Product> testProduct = productRepository.getProduct(1);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 60);
        assertEquals(472.5, result);
    }

    @Test
    void calculatePriceForThreeHorseshoeCarton() {
        Optional<Product> testProduct = productRepository.getProduct(2);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 15);
        assertEquals(2227.5, result);
    }

    @Test
    void calculatePriceFor25PenguinEarsCarton() {
        Optional<Product> testProduct = productRepository.getProduct(1);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 25);
        assertEquals(231.88, result);
    }

    @Test
    void calculatePriceFor8HorseshoeCarton() {
        Optional<Product> testProduct = productRepository.getProduct(2);
        double result = priceEngineService.calculatePrice(testProduct.get().getId(), 8);
        assertEquals(1468.5, result);
    }
}