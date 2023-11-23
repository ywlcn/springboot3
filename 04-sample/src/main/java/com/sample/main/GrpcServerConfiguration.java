package com.sample.main;

import com.sample.grpc.server.interceptor.ServerDelegateInterceptor;
import io.grpc.ServerInterceptor;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.grpc.v1_6.GrpcTelemetry;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ConditionalOnProperty(prefix = "app", name = "role", havingValue = "grpc-server")
@ComponentScan({"com.sample.grpc.server"})
public class GrpcServerConfiguration {
    @Bean
    @GRpcGlobalInterceptor
    public ServerInterceptor gRPCTracingServerInterceptor(OpenTelemetry openTelemetry) throws Exception {
        GrpcTelemetry grpcTelemetry = GrpcTelemetry.create(openTelemetry);
        return grpcTelemetry.newServerInterceptor();
    }
}
