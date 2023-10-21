package com.baeldung.opentelemetry.model;

import com.baeldung.opentelemetry.ManualApplication;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;

public class Product {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Price price;
    private Tracer tracer;

    public Product(long id, String name, OpenTelemetry openTelemetry) {
        this.id = id;
        this.name = name;
        this.tracer = openTelemetry.getTracer(Product.class.getName(), ManualApplication.VERSION);
    }

    public Product(long id, String name) {
        this(id, name, OpenTelemetry.noop());
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
