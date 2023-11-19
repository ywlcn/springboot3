package com.boot.opentelemetry.controller;


import com.boot.opentelemetry.model.Price;
import com.boot.opentelemetry.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class PriceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    private final PriceRepository priceRepository;

    @Autowired
    public PriceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping(path = "/price/{id}")
    public Price getPrice(@PathVariable("id") long productId) {

//        WebClient webClient= WebClient.builder()
//                .baseUrl("http://localhost:8080")
//                .build();
//
//        webClient.post()
//                .uri("/users")
//                .contentType(MediaType.APPLICATION_JSON) // リクエストボディのタイプ
//                .body("", String.class) // リクエストボディ
////                .syncBody(message)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block(); // ブロッキング



        LOGGER.info("Getting Price details for Product Id {}", productId);
        return priceRepository.getPrice(productId);
    }
}
