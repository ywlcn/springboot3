package com.sample.filter;

import jakarta.servlet.*;
import org.springframework.web.context.request.async.WebAsyncManager;

import java.io.IOException;

public class GraphqlFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        WebAsyncManager manager =



        chain.doFilter(request, response);
    }
}
