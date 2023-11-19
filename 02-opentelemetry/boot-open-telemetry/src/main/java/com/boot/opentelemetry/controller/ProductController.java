package com.boot.opentelemetry.controller;

import com.boot.opentelemetry.client.PriceClient;
import com.boot.opentelemetry.model.Product;
import com.boot.opentelemetry.repository.ProductRepository;
import com.boot.opentelemetry.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private  PriceClient priceClient;

    @Autowired
    ProductService productService;

    @GetMapping(path = "/product/{id}")
    public Product getProductDetails(@PathVariable("id") long productId) {
        LOGGER.info("Getting Product and Price Details With Product Id {}", productId);
        Product product = productService.getProduct(productId);
        product.setPrice(priceClient.getPrice(productId));
        return product;
    }
}
