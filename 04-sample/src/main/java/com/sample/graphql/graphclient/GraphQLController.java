package com.sample.graphql.graphclient;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

public class GraphQLController {

    private final HttpGraphQlClient graphQlClient;

    public GraphQLController() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }



}
