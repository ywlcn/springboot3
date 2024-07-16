package com.sample.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class WebGraphQlLogInterceptor implements WebGraphQlInterceptor, Ordered {

    private final Logger logger = LoggerFactory.getLogger(WebGraphQlLogInterceptor.class);

    int order = -1;

    public WebGraphQlLogInterceptor(int order) {
        this.order = order;
    }

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        logger.warn("WebGraphQlLogInterceptor[" + order + "]--->intercept");
        return chain.next(request)
                .timeout(Duration.ofSeconds(5))
                .doFinally(f -> {
            logger.warn("WebGraphQlLogInterceptor[" + order + "]--->intercept--->doFinally");
        });
    }

    @Override
    public WebGraphQlInterceptor andThen(WebGraphQlInterceptor nextInterceptor) {
        logger.warn("WebGraphQlLogInterceptor[" + order + "]--->andThen");
        return WebGraphQlInterceptor.super.andThen(nextInterceptor);
    }

    @Override
    public Chain apply(Chain chain) {
        logger.warn("WebGraphQlLogInterceptor[" + order + "]--->apply");
        return WebGraphQlInterceptor.super.apply(chain);
    }

    @Override
    public int getOrder() {
        return order;
    }
}
