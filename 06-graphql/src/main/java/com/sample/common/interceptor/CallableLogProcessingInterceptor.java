package com.sample.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

import java.util.concurrent.Callable;


public class CallableLogProcessingInterceptor implements CallableProcessingInterceptor {
    public static final String registerKey = CallableLogProcessingInterceptor.class.getName();

    private final Logger logger = LoggerFactory.getLogger(CallableLogProcessingInterceptor.class);

    protected final RequestAttributes attri;
    protected final String requestId;

    public CallableLogProcessingInterceptor(String requestId , RequestAttributes attri){
        this.requestId = requestId;
        this.attri = attri;
    }
    public CallableLogProcessingInterceptor(){
        this.requestId = "";
        this.attri = null;
    }
    /**
     * Invoked <em>before</em> the start of concurrent handling in the original
     * thread in which the {@code Callable} is submitted for concurrent handling.
     * <p>This is useful for capturing the state of the current thread just prior to
     * invoking the {@link Callable}. Once the state is captured, it can then be
     * transferred to the new {@link Thread} in
     * {@link #preProcess(NativeWebRequest, Callable)}. Capturing the state of
     * Spring Security's SecurityContextHolder and migrating it to the new Thread
     * is a concrete example of where this is useful.
     * <p>The default implementation is empty.
     *
     * @param request the current request
     * @param task    the task for the current async request
     * @throws Exception in case of errors
     */
    @Override
    public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
        logger.warn("LogCallableProcessingInterceptor--->beforeConcurrentHandling");
        CallableProcessingInterceptor.super.beforeConcurrentHandling(request, task);
    }

    /**
     * Invoked <em>after</em> the start of concurrent handling in the async
     * thread in which the {@code Callable} is executed and <em>before</em> the
     * actual invocation of the {@code Callable}.
     * <p>The default implementation is empty.
     *
     * @param request the current request
     * @param task    the task for the current async request
     * @throws Exception in case of errors
     */
    @Override
    public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
        logger.warn("LogCallableProcessingInterceptor--->preProcess");
        CallableProcessingInterceptor.super.preProcess(request, task);
    }

    /**
     * Invoked <em>after</em> the {@code Callable} has produced a result in the
     * async thread in which the {@code Callable} is executed. This method may
     * be invoked later than {@code afterTimeout} or {@code afterCompletion}
     * depending on when the {@code Callable} finishes processing.
     * <p>The default implementation is empty.
     *
     * @param request          the current request
     * @param task             the task for the current async request
     * @param concurrentResult the result of concurrent processing, which could
     *                         be a {@link Throwable} if the {@code Callable} raised an exception
     * @throws Exception in case of errors
     */
    @Override
    public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
        logger.warn("LogCallableProcessingInterceptor--->postProcess");
        CallableProcessingInterceptor.super.postProcess(request, task, concurrentResult);
    }

    /**
     * Invoked from a container thread when the async request times out before
     * the {@code Callable} task completes. Implementations may return a value,
     * including an {@link Exception}, to use instead of the value the
     * {@link Callable} did not return in time.
     * <p>The default implementation always returns {@link #RESULT_NONE}.
     *
     * @param request the current request
     * @param task    the task for the current async request
     * @return a concurrent result value; if the value is anything other than
     * {@link #RESULT_NONE} or {@link #RESPONSE_HANDLED}, concurrent processing
     * is resumed and subsequent interceptors are not invoked
     * @throws Exception in case of errors
     */
    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        logger.warn("LogCallableProcessingInterceptor--->handleTimeout");
        return CallableProcessingInterceptor.super.handleTimeout(request, task);
    }

    /**
     * Invoked from a container thread when an error occurred while processing
     * the async request before the {@code Callable} task completes.
     * Implementations may return a value, including an {@link Exception}, to
     * use instead of the value the {@link Callable} did not return in time.
     * <p>The default implementation always returns {@link #RESULT_NONE}.
     *
     * @param request the current request
     * @param task    the task for the current async request
     * @param t       the error that occurred while request processing
     * @return a concurrent result value; if the value is anything other than
     * {@link #RESULT_NONE} or {@link #RESPONSE_HANDLED}, concurrent processing
     * is resumed and subsequent interceptors are not invoked
     * @throws Exception in case of errors
     * @since 5.0
     */
    @Override
    public <T> Object handleError(NativeWebRequest request, Callable<T> task, Throwable t) throws Exception {
        logger.warn("LogCallableProcessingInterceptor--->handleError");
        return CallableProcessingInterceptor.super.handleError(request, task, t);
    }

    /**
     * Invoked from a container thread when async processing completes for any
     * reason including timeout or network error.
     * <p>The default implementation is empty.
     *
     * @param request the current request
     * @param task    the task for the current async request
     * @throws Exception in case of errors
     */
    @Override
    public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
        logger.warn("LogCallableProcessingInterceptor--->afterCompletion");
        CallableProcessingInterceptor.super.afterCompletion(request, task);
    }
}

