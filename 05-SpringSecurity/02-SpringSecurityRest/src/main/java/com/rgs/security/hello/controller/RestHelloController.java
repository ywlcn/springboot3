package com.rgs.security.hello.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

    @GetMapping(value = "/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("user", HttpStatus.OK);
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("admin", HttpStatus.OK);
    }

}