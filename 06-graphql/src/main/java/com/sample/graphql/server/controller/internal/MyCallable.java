package com.sample.graphql.server.controller.internal;

import org.slf4j.MDC;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class MyCallable implements Callable {

    public static final String REQUEST_ID = "requestId";

    protected final RequestAttributes attri;
    protected final Function func;
    protected final Object arg;
    protected final String requestId;

    public MyCallable(Function func, Object arg) {
        this.arg = arg;
        this.requestId = MDC.get(REQUEST_ID);
        this.func = func;
        this.attri = RequestContextHolder.getRequestAttributes();
    }


    @Override
    public Object call() throws Exception {

        // RequestScope   ログ・・・
        try {
            RequestContextHolder.setRequestAttributes(attri);
            MDC.put(REQUEST_ID, requestId);
        } catch (Exception ignored) {
        }

        try {
            return func.apply(arg);
        } finally {
            RequestContextHolder.setRequestAttributes(null);
            MDC.remove(REQUEST_ID);
        }


    }


}
