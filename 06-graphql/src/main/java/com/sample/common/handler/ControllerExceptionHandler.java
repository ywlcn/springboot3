package com.sample.common.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
//@Component
public class ControllerExceptionHandler  {

//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    @org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
//    @ResponseBody
//    public Map<String, Object> handleError() {
//        Map<String, Object> errorMap = new HashMap<String, Object>();
//        errorMap.put("message", "許可されていないメソッド");
//        errorMap.put("status", HttpStatus.METHOD_NOT_ALLOWED);
//        return errorMap;
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
    public String handleError() {
        return "error";
    }
}
