package com.sample.grpc.util;

import io.micrometer.observation.transport.Kind;
import io.micrometer.observation.transport.Propagator;
import io.micrometer.observation.transport.RequestReplySenderContext;

public class GrpcClientRequestObservationContext extends RequestReplySenderContext {
    public GrpcClientRequestObservationContext(Propagator.Setter setter, Kind kind) {
        super(setter, kind);
    }

    public GrpcClientRequestObservationContext(Propagator.Setter setter) {
        super(setter);
    }
}
