package com.sample.main;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "role", havingValue = "grpc-client")
@ComponentScan({"com.sample.grpc.client"})
public class FrontendConfiguration {

}
