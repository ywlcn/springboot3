package com.boot.opentelemetry.service;

import com.boot.opentelemetry.model.Product;

public interface ProductService {


    Product getProduct(Long productId);

}
