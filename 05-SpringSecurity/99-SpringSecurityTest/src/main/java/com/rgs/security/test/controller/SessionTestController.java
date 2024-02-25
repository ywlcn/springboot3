package com.rgs.security.test.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.UUID;

@Controller
public class SessionTestController {


    @GetMapping(value = "/session")
    public String session(HttpServletRequest seq, Model model) {
        HttpSession session = seq.getSession(false);
        System.err.println("SessionId:" + session.getId());
        session.getAttributeNames().asIterator().forEachRemaining(System.err::println);
        String key = UUID.randomUUID().toString();
        session.setAttribute("key--" + key , key);
        System.err.println("-------------------------------------------------------------------");
        return "session";
    }

    @PostMapping(value = "/csrf")
    public String csrf(HttpServletRequest seq) {
        return "session";
    }


}