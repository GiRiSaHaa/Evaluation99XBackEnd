package com.nintyninex.technical.assessment.services;

import com.nintyninex.technical.assessment.models.Product;
import com.nintyninex.technical.assessment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for manage product related services.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Provide all products.
     * @return the all products.
     */
    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }
}
