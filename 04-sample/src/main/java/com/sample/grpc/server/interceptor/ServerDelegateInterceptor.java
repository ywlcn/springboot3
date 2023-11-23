package com.sample.grpc.server.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.lognet.springboot.grpc.GRpcService;


public class ServerDelegateInterceptor implements ServerInterceptor {

    ServerInterceptor delegate;

    public ServerDelegateInterceptor(ServerInterceptor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        return delegate.interceptCall(call, headers, next);
    }
}
