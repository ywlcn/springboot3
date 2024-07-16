package com.sample.common.interceptor;

import com.sample.graphql.server.controller.internal.MyCallable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.async.AsyncWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

public class DeferredResultLogProcessingInterceptor implements DeferredResultProcessingInterceptor {

    public static final String registerKey = DeferredResultLogProcessingInterceptor.class.getName();

    private final Logger logger = LoggerFactory.getLogger(DeferredResultLogProcessingInterceptor.class);

    protected final RequestAttributes attri;
    protected final String requestId;

    protected final String addTime;

    public DeferredResultLogProcessingInterceptor(String requestId, RequestAttributes attri,
                                                  String addTime) {
        this.requestId = requestId;
        this.attri = attri;
        this.addTime = addTime;
    }

    public DeferredResultLogProcessingInterceptor(String addTime) {
        this.requestId = "";
        this.attri = null;
        this.addTime = addTime;
    }

    /**
     * Invoked immediately before the start of concurrent handling, in the same
     * thread that started it. This method may be used to capture state just prior
     * to the start of concurrent processing with the given {@code DeferredResult}.
     *
     * @param request        the current request
     * @param deferredResult the DeferredResult for the current request
     * @throws Exception in case of errors
     */
    @Override
    public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
        logger.warn("[" + addTime + "]LogDeferredResultProcessingInterceptor--->beforeConcurrentHandling");
        if (request instanceof AsyncWebRequest asyncWebRequest){
            asyncWebRequest.setTimeout(5000L);
        }
        DeferredResultProcessingInterceptor.super.beforeConcurrentHandling(request, deferredResult);
    }

    /**
     * Invoked immediately after the start of concurrent handling, in the same
     * thread that started it. This method may be used to detect the start of
     * concurrent processing with the given {@code DeferredResult}.
     * <p>The {@code DeferredResult} may have already been set, for example at
     * the time of its creation or by another thread.
     *
     * @param request        the current request
     * @param deferredResult the DeferredResult for the current request
     * @throws Exception in case of errors
     */
    @Override
    public <T> void preProcess(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
        logger.warn("[" + addTime + "]LogDeferredResultProcessingInterceptor--->preProcess");
        DeferredResultProcessingInterceptor.super.preProcess(request, deferredResult);
    }

    /**
     * Invoked after a {@code DeferredResult} has been set, via
     * {@link DeferredResult#setResult(Object)} or
     * {@link DeferredResult#setErrorResult(Object)}, and is also ready to
     * handle the concurrent result.
     * <p>This method may also be invoked after a timeout when the
     * {@code DeferredResult} was created with a constructor accepting a default
     * timeout result.
     *
     * @param request          the current request
     * @param deferredResult   the DeferredResult for the current request
     * @param concurrentResult the concurrent result
     * @throws Exception in case of errors
     */
    @Override
    public <T> void postProcess(NativeWebRequest request, DeferredResult<T> deferredResult, Object concurrentResult) throws Exception {
        logger.warn("[" + addTime + "]LogDeferredResultProcessingInterceptor--->postProcess");
        DeferredResultProcessingInterceptor.super.postProcess(request, deferredResult, concurrentResult);
    }

    /**
     * Invoked from a container thread when an async request times out before
     * the {@code DeferredResult} has been set. Implementations may invoke
     * {@link DeferredResult#setResult(Object) setResult} or
     * {@link DeferredResult#setErrorResult(Object) setErrorResult} to resume processing.
     *
     * @param request        the current request
     * @param deferredResult the DeferredResult for the current request; if the
     *                       {@code DeferredResult} is set, then concurrent processing is resumed and
     *                       subsequent interceptors are not invoked
     * @return {@code true} if processing should continue, or {@code false} if
     * other interceptors should not be invoked
     * @throws Exception in case of errors
     */
    @Override
    public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
        logger.warn("[" + addTime + "]LogDeferredResultProcessingInterceptor--->handleTimeout");
        return DeferredResultProcessingInterceptor.super.handleTimeout(request, deferredResult);
    }

    /**
     * Invoked from a container thread when an error occurred while processing an async request
     * before the {@code DeferredResult} has been set. Implementations may invoke
     * {@link DeferredResult#setResult(Object) setResult} or
     * {@link DeferredResult#setErrorResult(Object) setErrorResult} to resume processing.
     *
     * @param request        the current request
     * @param deferredResult the DeferredResult for the current request; if the
     *                       {@code DeferredResult} is set, then concurrent processing is resumed and
     *                       subsequent interceptors are not invoked
     * @param t              the error that occurred while request processing
     * @return {@code true} if error handling should continue, or {@code false} if
     * other interceptors should be bypassed and not be invoked
     * @throws Exception in case of errors
     */
    @Override
    public <T> boolean handleError(NativeWebRequest request, DeferredResult<T> deferredResult, Throwable t) throws Exception {
        logger.warn("[" + addTime + "]LogDeferredResultProcessingInterceptor--->handleError");
        return DeferredResultProcessingInterceptor.super.handleError(request, deferredResult, t);
    }

    /**
     * Invoked from a container thread when an async request completed for any
     * reason including timeout and network error. This method is useful for
     * detecting that a {@code DeferredResult} instance is no longer usable.
     *
     * @param request        the current request
     * @param deferredResult the DeferredResult for the current request
     * @throws Exception in case of errors
     */
    @Override
    public <T> void afterCompletion(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
        MDC.put(MyCallable.REQUEST_ID, requestId);
        RequestContextHolder.setRequestAttributes(attri);
        logger.warn("[" + addTime + "]LogDeferredResultProcessingInterceptor--->afterCompletion");
        DeferredResultProcessingInterceptor.super.afterCompletion(request, deferredResult);
    }
}
