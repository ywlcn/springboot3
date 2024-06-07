package com.sample.filter;

import com.sample.filter.internal.IdGenerator;
import com.sample.graphql.server.controller.internal.MyCallable;
import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;

public class RequestIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestID = IdGenerator.generate();
        MDC.put(MyCallable.REQUEST_ID, requestID);
        RequestContextHolder.getRequestAttributes().setAttribute(MyCallable.REQUEST_ID, requestID, RequestAttributes.SCOPE_REQUEST);

        chain.doFilter(request, response);

    }
}
