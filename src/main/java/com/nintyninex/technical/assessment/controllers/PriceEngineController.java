package com.nintyninex.technical.assessment.controllers;

import com.nintyninex.technical.assessment.dto.PriceListResponse;
import com.nintyninex.technical.assessment.services.PriceEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controller class for expose price engine related APIs.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/price")
public class PriceEngineController {

    private final PriceEngineService priceEngineService;

    public PriceEngineController(PriceEngineService priceEngineService) {
        this.priceEngineService = priceEngineService;
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

    /**
     * Return price list for given range of quantity.
     * @param productId the product ID to get price list.
     * @param count the range of quantity.
     * @return the List of price for given range of quantities.
     */
    @RequestMapping(value = "/calculate/price-list/{productId}/{count}", method = GET)
    @ResponseBody
    public List<PriceListResponse> getBulkPriceList(@PathVariable("productId") long productId, @PathVariable("count") int count ){
        return priceEngineService.getBulkPriceList(productId, count);
    }
}
