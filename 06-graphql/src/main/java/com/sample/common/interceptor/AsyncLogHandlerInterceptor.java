package com.sample.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AsyncLogHandlerInterceptor implements AsyncHandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(AsyncLogHandlerInterceptor.class);

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.warn("AsyncLogHandlerInterceptor--->afterConcurrentHandlingStarted");
        AsyncHandlerInterceptor.super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.warn("AsyncLogHandlerInterceptor--->preHandle");
        return AsyncHandlerInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.warn("AsyncLogHandlerInterceptor--->postHandle");
        AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.warn("AsyncLogHandlerInterceptor--->afterCompletion");
        AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
