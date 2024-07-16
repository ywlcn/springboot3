package com.sample.common.filter;

import com.sample.common.filter.internal.IdGenerator;
import com.sample.graphql.server.controller.internal.MyCallable;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;

public class LogFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.warn("LogFilter---上り通過+[" + request.getDispatcherType() +"]" + "[" + ((HttpServletRequest) request).getRequestURL() + "]");
        chain.doFilter(request, response);
        logger.warn("LogFilter---下り通過+[" + request.getDispatcherType() +"]" + "[" + ((HttpServletRequest) request).getRequestURL() + "]");
    }
}
