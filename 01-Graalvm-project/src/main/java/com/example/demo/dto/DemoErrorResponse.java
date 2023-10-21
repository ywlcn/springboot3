package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

import java.util.Locale;

@Getter
@Setter
public class DemoErrorResponse implements ErrorResponse {
    Exception error ;
    HttpStatusCode httpStatusCode;
    ProblemDetail problemDetail;
    public DemoErrorResponse(Exception e) {
        this.error = e;
        problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        httpStatusCode = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return httpStatusCode;
    }

    @Override
    public HttpHeaders getHeaders() {
        return ErrorResponse.super.getHeaders();
    }

    @Override
    public ProblemDetail getBody() {
        return problemDetail;
    }

    @Override
    public String getDetailMessageCode() {
        return ErrorResponse.super.getDetailMessageCode();
    }

    @Override
    public Object[] getDetailMessageArguments() {
        return ErrorResponse.super.getDetailMessageArguments();
    }

    @Override
    public Object[] getDetailMessageArguments(MessageSource messageSource, Locale locale) {
        return ErrorResponse.super.getDetailMessageArguments(messageSource, locale);
    }

    @Override
    public String getTitleMessageCode() {
        return ErrorResponse.super.getTitleMessageCode();
    }

    @Override
    public ProblemDetail updateAndGetBody(MessageSource messageSource, Locale locale) {
        return ErrorResponse.super.updateAndGetBody(messageSource, locale);
    }


}