package com.sample.grpc.client.interceptor;

import com.google.protobuf.util.JsonFormat;
import com.sample.grpc.util.GrpcClientRequestObservationContext;
import io.grpc.*;
import io.micrometer.observation.Observation;
import jakarta.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.observation.ClientHttpObservationDocumentation;
import org.springframework.http.client.observation.ClientRequestObservationContext;
import org.springframework.http.client.observation.ClientRequestObservationConvention;
import org.springframework.http.client.observation.DefaultClientRequestObservationConvention;
import org.springframework.web.client.RestClientException;

public class OTLPClientInterceptor implements ClientInterceptor {

    static Logger logger = LoggerFactory.getLogger(OTLPClientInterceptor.class);

    private static final ClientRequestObservationConvention DEFAULT_OBSERVATION_CONVENTION = new DefaultClientRequestObservationConvention();


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                               CallOptions callOptions, Channel channel) {

        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                channel.newCall(methodDescriptor, callOptions)) {



            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {

                GrpcClientRequestObservationContext observationContext = new GrpcClientRequestObservationContext(null);
                //ClientRequestObservationContext observationContext = new ClientRequestObservationContext(request);
                //observationContext.setUriTemplate(uriTemplate);
                Observation observation = null;
//                Observation observation = ClientHttpObservationDocumentation.HTTP_CLIENT_EXCHANGES.observation(this.observationConvention,
//                        DEFAULT_OBSERVATION_CONVENTION, () -> observationContext, this.observationRegistry).start();


                    super.start(new ClientCall.Listener<RespT>() {
                        public void onHeaders(Metadata headers) {
                            responseListener.onHeaders(headers);
                        }

                        public void onMessage(RespT message) {
                            responseListener.onMessage(message);
                        }

                        public void onClose(Status status, Metadata trailers) {
                            responseListener.onClose(status, trailers);
                            observation.stop();
                        }

                        public void onReady() {
                            responseListener.onReady();
                        }

                    }, headers);
            }

            @Override
            public void request(int numMessages) {
                super.request(numMessages);
            }

            @Override
            public void cancel(@Nullable String message, @Nullable Throwable cause) {
                super.cancel(message, cause);
            }

            @Override
            public void halfClose() {
                super.halfClose();
            }

            @Override
            public void sendMessage(ReqT message) {
                super.sendMessage(message);
            }



        };




    }

}