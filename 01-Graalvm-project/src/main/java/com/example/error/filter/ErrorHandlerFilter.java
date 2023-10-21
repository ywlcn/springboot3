package com.example.error.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ErrorHandlerFilter implements Filter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        try{
            chain.doFilter(req, res);
        }catch(Exception ex){
            log.info("下り処理例外発生しています。",ex);
        }finally {

        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void destroy() {
    }
}
