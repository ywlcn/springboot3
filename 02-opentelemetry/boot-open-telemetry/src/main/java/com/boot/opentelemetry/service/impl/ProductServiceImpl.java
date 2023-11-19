package com.boot.opentelemetry.service.impl;

import com.boot.opentelemetry.model.Product;
import com.boot.opentelemetry.repository.ProductRepository;
import com.boot.opentelemetry.service.ProductService;
import io.micrometer.observation.annotation.Observed;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Product getProduct(Long productId) {
        return productRepository.getProduct(productId);
    }
}
