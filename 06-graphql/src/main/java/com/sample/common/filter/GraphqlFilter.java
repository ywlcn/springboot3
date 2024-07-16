package com.sample.common.filter;

import com.sample.common.interceptor.CallableLogProcessingInterceptor;
import com.sample.common.interceptor.DeferredResultLogProcessingInterceptor;
import com.sample.graphql.server.controller.internal.MyCallable;
import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;

import java.io.IOException;

public class GraphqlFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
        CallableLogProcessingInterceptor callableInterceptor = (CallableLogProcessingInterceptor) asyncManager
                .getCallableInterceptor(CallableLogProcessingInterceptor.registerKey);
        if (callableInterceptor == null) {
            callableInterceptor =
                    new CallableLogProcessingInterceptor(MDC.get(MyCallable.REQUEST_ID),
                            RequestContextHolder.getRequestAttributes());
            asyncManager.registerCallableInterceptor(CallableLogProcessingInterceptor.registerKey, callableInterceptor);
        }
        DeferredResultLogProcessingInterceptor deferredResultInterceptor = (DeferredResultLogProcessingInterceptor) asyncManager
                .getCallableInterceptor(DeferredResultLogProcessingInterceptor.registerKey);
        if (deferredResultInterceptor == null) {
            deferredResultInterceptor =
                    new DeferredResultLogProcessingInterceptor(MDC.get(MyCallable.REQUEST_ID),
                            RequestContextHolder.getRequestAttributes(), "Filter");
            asyncManager.registerDeferredResultInterceptor(DeferredResultLogProcessingInterceptor.registerKey, deferredResultInterceptor);
        }
        chain.doFilter(request, response);
    }
}
