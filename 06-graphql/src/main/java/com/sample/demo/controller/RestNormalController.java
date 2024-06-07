package com.sample.demo.controller;

import com.sample.dto.DemoErrorResponse;
import com.sample.dto.User;
import com.sample.graphql.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RestNormalController {

    Logger loger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/getall")
    public List<User> showCities() {
        return userService.findALl();
    }


    @ExceptionHandler(Exception.class)
    public DemoErrorResponse handleException(Exception exception) {
        return new DemoErrorResponse(exception);
    }


}