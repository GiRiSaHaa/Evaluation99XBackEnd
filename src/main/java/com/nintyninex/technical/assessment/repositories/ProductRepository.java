package com.nintyninex.technical.assessment.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nintyninex.technical.assessment.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for manage product related queries.
 */
@Repository
public class ProductRepository {

    // create Object Mapper
    ObjectMapper mapper = new ObjectMapper();

    /**
     * Return all products.
     * @return the list of all Products
     */
    public List<Product> getAllProducts() {

        List<Product> productList = null;

        // read JSON file and map/convert to java POJO
        try {
            File file = ResourceUtils.getFile("classpath:./static/product-list.json");
            productList = Arrays.asList(mapper.readValue(file, Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    /**
     * Return product for given product ID.
     * @param productId the Product ID.
     * @return the Product.
     */
    public Optional<Product> getProduct(long productId){
        return getAllProducts().stream().filter( p -> p.getId() == productId).findFirst();
    }
}
