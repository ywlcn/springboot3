package com.sample.observe.hanlder;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class MyObserveHandler  implements ObservationHandler<Observation.Context> {

    private static final Logger log = LoggerFactory.getLogger(MyObserveHandler.class);

    @Override
    public void onStart(Observation.Context context) {
        context.addLowCardinalityKeyValue(KeyValue.of("user-test","user-start-^^"));
        log.info("Before running the observation for context [{}], userType [{}]", context.getName(), getUserTypeFromContext(context));
    }

    @Override
    public void onStop(Observation.Context context) {
        context.addLowCardinalityKeyValue(KeyValue.of("user-test","user-end-^^"));
        log.info("After running the observation for context [{}], userType [{}]", context.getName(), getUserTypeFromContext(context));
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    private String getUserTypeFromContext(Observation.Context context) {
        return StreamSupport.stream(context.getLowCardinalityKeyValues().spliterator(), false)
                .filter(keyValue -> "userType".equals(keyValue.getKey()))
                .map(KeyValue::getValue)
                .findFirst()
                .orElse("UNKNOWN");
    }
}
