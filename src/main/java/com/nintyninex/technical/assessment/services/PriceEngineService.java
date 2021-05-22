package com.nintyninex.technical.assessment.services;

import com.nintyninex.technical.assessment.models.Product;
import com.nintyninex.technical.assessment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class PriceEngineService {

    private final ProductRepository productRepository;

    public PriceEngineService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getAllProducts();
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

    private double getTotalCartonPrice(int qty, Optional<Product> product) {
        int cartonCount = qty / product.get().getUnitPerCarton();
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
        System.out.println("Remaining Qty: " + qty);
        double totalUnitPrice = product.getCartonPrice() / product.getUnitPerCarton() * 1.3 * qty;
        System.out.println("totalUnitPrice: " + totalUnitPrice);
        BigDecimal bd = new BigDecimal(totalUnitPrice).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
