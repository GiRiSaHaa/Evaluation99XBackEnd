package com.nintyninex.technical.assessment.services;

import com.nintyninex.technical.assessment.dto.PriceListResponse;
import com.nintyninex.technical.assessment.models.Product;
import com.nintyninex.technical.assessment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Service class for manage price related services.
 */
@Service
public class PriceEngineService {

    private final ProductRepository productRepository;

    public PriceEngineService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Calculate price for given product with quantity
     * @param productId the selected product ID
     * @param qty the quantity of the product.
     * @return the calculated price.
     */
    public double calculatePrice(Long productId, int qty) {
        Optional<Product> product = productRepository.getProduct(productId);
        double totalCartonPrice = getTotalCartonPrice(qty, product);
        double totalUnitPrice = getTotalUnitPrice(product.get(), qty % product.get().getUnitPerCarton());
        return totalCartonPrice + totalUnitPrice;
    }

    /**
     * This method will provide total carton price for given product and the quantity.
     * @param qty the Product quantity.
     * @param product The Product.
     * @return the total carton price.
     */
    private double getTotalCartonPrice(int qty, Optional<Product> product) {
        int cartonCount = qty / product.get().getUnitPerCarton();
        // if carton count is 0
        if(cartonCount == 0) return cartonCount;

        double totalCartonPrice = cartonCount * product.get().getCartonPrice();
        return (cartonCount >= 3) ? totalCartonPrice * 0.9 : totalCartonPrice;
    }

    /**
     * Return total price for remaining items.
     * @param product the product
     * @param qty the quantity
     * @return the total remain unit price.
     */
    private double getTotalUnitPrice(Product product,int qty) {
        if ( qty == 0 ) return 0;
        double totalUnitPrice = product.getCartonPrice() / product.getUnitPerCarton() * 1.3 * qty;
        BigDecimal bd = new BigDecimal(totalUnitPrice).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * This method will return price list of given product for given range of quantity.
     * @param productId the Product ID
     * @param count the range of quantity.
     * @return the Price list
     */
    public List<PriceListResponse> getBulkPriceList(long productId, int count) {
        List<PriceListResponse> priceList = new ArrayList<>();
        PriceListResponse priceListResponse;
        for(int i = 1; i <= count; i++){
            priceListResponse = new PriceListResponse(i,calculatePrice(productId,i));
            priceList.add(priceListResponse);
        }
        return priceList;
    }
}
