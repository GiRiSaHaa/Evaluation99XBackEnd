package com.nintyninex.technical.assessment.controllers;

import com.nintyninex.technical.assessment.models.Product;
import com.nintyninex.technical.assessment.services.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controller class for expose product related APIs.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Return list of products
     * @return the list of all products.
     */
    @RequestMapping(method = GET, path ="/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
