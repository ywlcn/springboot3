# SpringBootのAutoConfig

# 1. 起動時









# 2. 業務処理時







```
ServerHttpObservationFilter


onEnd:101, BatchSpanProcessor (io.opentelemetry.sdk.trace.export)
endInternal:445, SdkSpan (io.opentelemetry.sdk.trace)
end:425, SdkSpan (io.opentelemetry.sdk.trace)
end:131, SpanFromSpanContext (io.micrometer.tracing.otel.bridge)
end:147, OtelSpan (io.micrometer.tracing.otel.bridge)
endSpan:215, TracingObservationHandler (io.micrometer.tracing.handler)
onStop:101, PropagatingReceiverTracingObservationHandler (io.micrometer.tracing.handler)
onStop:35, PropagatingReceiverTracingObservationHandler (io.micrometer.tracing.handler)
onStop:197, ObservationHandler$FirstMatchingCompositeObservationHandler (io.micrometer.observation)
lambda$notifyOnObservationStopped$0:276, SimpleObservation (io.micrometer.observation)
accept:-1, SimpleObservation$$Lambda$1061/0x0000028b8155dbd0 (io.micrometer.observation)
forEachRemaining:772, ArrayDeque$DescendingIterator (java.util)
notifyOnObservationStopped:276, SimpleObservation (io.micrometer.observation)
stop:196, SimpleObservation (io.micrometer.observation)
doFilterInternal:123, ServerHttpObservationFilter (org.springframework.web.filter)
doFilter:116, OncePerRequestFilter (org.springframework.web.filter)
internalDoFilter:174, ApplicationFilterChain (org.apache.catalina.core)
doFilter:149, ApplicationFilterChain (org.apache.catalina.core)
doFilterInternal:201, CharacterEncodingFilter (org.springframework.web.filter)
doFilter:116, OncePerRequestFilter (org.springframework.web.filter)
internalDoFilter:174, ApplicationFilterChain (org.apache.catalina.core)
doFilter:149, ApplicationFilterChain (org.apache.catalina.core)
invoke:167, StandardWrapperValve (org.apache.catalina.core)
invoke:90, StandardContextValve (org.apache.catalina.core)
invoke:482, AuthenticatorBase (org.apache.catalina.authenticator)
invoke:115, StandardHostValve (org.apache.catalina.core)
invoke:93, ErrorReportValve (org.apache.catalina.valves)
invoke:74, StandardEngineValve (org.apache.catalina.core)
service:341, CoyoteAdapter (org.apache.catalina.connector)
service:391, Http11Processor (org.apache.coyote.http11)
process:63, AbstractProcessorLight (org.apache.coyote)
process:894, AbstractProtocol$ConnectionHandler (org.apache.coyote)
doRun:1740, NioEndpoint$SocketProcessor (org.apache.tomcat.util.net)
run:52, SocketProcessorBase (org.apache.tomcat.util.net)
runWorker:1191, ThreadPoolExecutor (org.apache.tomcat.util.threads)
run:659, ThreadPoolExecutor$Worker (org.apache.tomcat.util.threads)
run:61, TaskThread$WrappingRunnable (org.apache.tomcat.util.threads)
run:833, Thread (java.lang)
```





# 3. Span生成と送信

```
BatchSpanProcessor
```





























```
org.springframework.web.client.RestTemplate.doExecute()

		ClientRequestObservationContext observationContext = new ClientRequestObservationContext(request);
		observationContext.setUriTemplate(uriTemplate);
		Observation observation = ClientHttpObservationDocumentation.HTTP_CLIENT_EXCHANGES.observation(this.observationConvention,
				DEFAULT_OBSERVATION_CONVENTION, () -> observationContext, this.observationRegistry).start();




org.springframework.boot.actuate.metrics.web.reactive.client.ObservationWebClientCustomizer

DefaultClientRequestObservationConvention

org.springframework.boot.actuate.autoconfigure.observation.web.client.WebClientObservationConfiguration


```





```
request = {OkHttp3ClientHttpRequest@11971} 
 client = {OkHttpClient@11982} okhttp3.OkHttpClient@5f8c46e1
 uri = {URI@11967} "http://localhost:8080/price/100001"
 method = {HttpMethod@8721} "GET"
 bufferedOutput = {ByteArrayOutputStream@11983} ""
 headers = {HttpHeaders@11984}  size = 1
  "traceparent" -> {ArrayList@11991}  size = 1
   key = "traceparent"
   value = {ArrayList@11991}  size = 1
    0 = "00-1d716af6b9bfe172f580c2dc934a45a7-5c2792de8b2c42ae-01"
 executed = false
 readOnlyHeaders = null
```



```
result = {NamesEnumerator@9383} 
 pos = 1
 size = 7
 next = "traceparent"
 headers = 
   0 = {MimeHeaderField@9367} "traceparent: 00-33c669865ec1c13b1694ad302b9405b2-4093fe4d15265d1c-01"
   1 = {MimeHeaderField@9368} "accept: application/json, application/*+json"
   2 = {MimeHeaderField@9369} "content-length: 0"
   3 = {MimeHeaderField@9370} "host: localhost:8080"
   4 = {MimeHeaderField@9371} "connection: Keep-Alive"
   5 = {MimeHeaderField@9372} "accept-encoding: gzip"
   6 = {MimeHeaderField@9373} "user-agent: okhttp/4.10.0"
  count = 7
  limit = 100
  
  
  
  
  
```





# 4. ポイント

## 4.1 HttpServer

### (1) Filter

```Java
ServerHttpObservationFilter
```



## 4.2 RestClient

### (1) RestTemplate

```Java
@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
}
```

```java
	protected <T> T doExecute(URI url, @Nullable String uriTemplate, @Nullable HttpMethod method, @Nullable RequestCallback requestCallback,
			@Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {

		Assert.notNull(url, "url is required");
		Assert.notNull(method, "HttpMethod is required");
		ClientHttpRequest request;
		try {
			request = createRequest(url, method);
		}
		catch (IOException ex) {
			ResourceAccessException exception = createResourceAccessException(url, method, ex);
			throw exception;
		}
		ClientRequestObservationContext observationContext = new ClientRequestObservationContext(request);
		observationContext.setUriTemplate(uriTemplate);
		Observation observation = ClientHttpObservationDocumentation.HTTP_CLIENT_EXCHANGES.observation(this.observationConvention,
				DEFAULT_OBSERVATION_CONVENTION, () -> observationContext, this.observationRegistry).start();
		ClientHttpResponse response = null;
		try {
			if (requestCallback != null) {
				requestCallback.doWithRequest(request);
			}
			response = request.execute();
			observationContext.setResponse(response);
			handleResponse(url, method, response);
			return (responseExtractor != null ? responseExtractor.extractData(response) : null);
		}
		catch (IOException ex) {
			ResourceAccessException exception = createResourceAccessException(url, method, ex);
			observation.error(exception);
			throw exception;
		}
		catch (RestClientException exc) {
			observation.error(exc);
			throw exc;
		}
		finally {
			if (response != null) {
				response.close();
			}
			observation.stop();
		}
	}
```



### (2) WebClient

```Java
org.springframework.web.reactive.function.client.DefaultWebClient
```

```Java
@Bean
public WebClient webClient(WebClient.Builder builder) {
    return builder.build();
}
```

```Java
		@SuppressWarnings("deprecation")
		@Override
		public Mono<ClientResponse> exchange() {
			ClientRequestObservationContext observationContext = new ClientRequestObservationContext();
			ClientRequest.Builder requestBuilder = initRequestBuilder();
			return Mono.deferContextual(contextView -> {
				Observation observation = ClientHttpObservationDocumentation.HTTP_REACTIVE_CLIENT_EXCHANGES.observation(observationConvention,
						DEFAULT_OBSERVATION_CONVENTION, () -> observationContext, observationRegistry);
				observationContext.setCarrier(requestBuilder);
				observation
						.parentObservation(contextView.getOrDefault(ObservationThreadLocalAccessor.KEY, null))
						.start();
				ExchangeFilterFunction filterFunction = new ObservationFilterFunction(observationContext);
				if (filterFunctions != null) {
					filterFunction = filterFunctions.andThen(filterFunction);
				}
				ClientRequest request = requestBuilder.build();
				observationContext.setUriTemplate((String) request.attribute(URI_TEMPLATE_ATTRIBUTE).orElse(null));
				observationContext.setRequest(request);
				Mono<ClientResponse> responseMono = filterFunction.apply(exchangeFunction)
						.exchange(request)
						.checkpoint("Request to " + this.httpMethod.name() + " " + this.uri + " [DefaultWebClient]")
						.switchIfEmpty(NO_HTTP_CLIENT_RESPONSE_ERROR);
				if (this.contextModifier != null) {
					responseMono = responseMono.contextWrite(this.contextModifier);
				}
				final AtomicBoolean responseReceived = new AtomicBoolean();
				return responseMono
						.doOnNext(response -> responseReceived.set(true))
						.doOnError(observationContext::setError)
						.doFinally(signalType -> {
							if (signalType == SignalType.CANCEL && !responseReceived.get()) {
								observationContext.setAborted(true);
							}
							observation.stop();
						})
						.contextWrite(context -> context.put(ObservationThreadLocalAccessor.KEY, observation));
			});
		}
```



## 4.3 gRPC

```
implementation 'io.opentelemetry.instrumentation:opentelemetry-grpc-1.6:1.32.0-alpha'
```

### (1) client

```
GrpcTelemetry grpcTelemetry = GrpcTelemetry.create(openTelemetry);
ManagedChannelBuilder.forAddress(hostname, port).intercept(grpcTelemetry.newClientInterceptor());
```

### (2) server

```Java
@Bean
@GRpcGlobalInterceptor
public ServerInterceptor gRPCTracingServerInterceptor(OpenTelemetry openTelemetry) throws Exception {
    GrpcTelemetry grpcTelemetry = GrpcTelemetry.create(openTelemetry);
    return grpcTelemetry.newServerInterceptor();
}
```



## TODO

Handerの配置方法、順番について　Handerに何ができるのか？