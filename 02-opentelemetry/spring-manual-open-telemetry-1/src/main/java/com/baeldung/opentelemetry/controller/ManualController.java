package com.baeldung.opentelemetry.controller;

import com.baeldung.opentelemetry.ManualApplication;
import com.baeldung.opentelemetry.model.Product;
import com.baeldung.opentelemetry.repository.ProductRepository;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import com.baeldung.opentelemetry.client.PriceClient;

@RestController
public class ManualController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManualController.class);
    private final Tracer tracer;

    private final PriceClient priceClient;

    private final ProductRepository productRepository;

    @Autowired
    public ManualController(PriceClient priceClient, ProductRepository productRepository, OpenTelemetry openTelemetry) {
        this.priceClient = priceClient;
        this.productRepository = productRepository;
        tracer = openTelemetry.getTracer(ManualController.class.getName(), ManualApplication.VERSION);

    }

    @GetMapping(path = "/product/{id}")
    @WithSpan
    public Product getProductDetails(@SpanAttribute("productId") @PathVariable("id") long productId) {
        LOGGER.info("Getting Product and Price Details With Product Id {}", productId);
        Product product = productRepository.getProduct(productId);
        product.setPrice(priceClient.getPrice(productId));

        return product;
    }
}
