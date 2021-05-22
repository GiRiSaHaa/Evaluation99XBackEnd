package com.nintyninex.technical.assessment.controllers;

import com.nintyninex.technical.assessment.models.Product;
import com.nintyninex.technical.assessment.services.PriceEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/products")
public class PriceEngineController {

    private final PriceEngineService priceEngineService;

    public PriceEngineController(PriceEngineService priceEngineService) {
        this.priceEngineService = priceEngineService;
    }

    /**
     * Return list of products
     * @return the list of all products.
     */
    @RequestMapping(method = GET, path ="/products")
    public List<Product> getProducts(){
        return priceEngineService.getProducts();
    }

    /**
     * Calculate price for given product with quantity
     * @param productId productId the selected product ID
     * @param qty the quantity of the product.
     * @return the calculated price.
     */
    @RequestMapping(value = "/calculate/{productId}/{qty}", method = GET)
    @ResponseBody
    public double calculatePrice(@PathVariable("productId") long productId, @PathVariable("qty") int qty){
        return priceEngineService.calculatePrice(productId, qty);
    }
}
