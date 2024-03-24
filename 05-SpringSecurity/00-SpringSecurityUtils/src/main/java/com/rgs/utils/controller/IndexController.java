package com.rgs.utils.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpServletRequest req, HttpServletResponse rep) {
        System.out.println("---SessionId:" + req.getSession().getId());
        return "index";
    }

    @GetMapping("/index")
    public String getIndex(HttpServletRequest req, HttpServletResponse rep) {
        System.out.println("---SessionId:" + req.getSession().getId());
        return "index";
    }


    @GetMapping("/error")
    public ModelAndView handleError()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    public static void displaySession(HttpSession session){
        System.out.print("SessionId:" + session.getId());
        session.getAttributeNames().asIterator().forEachRemaining(System.out::println);
        String key = UUID.randomUUID().toString();
        session.setAttribute("login" + key , key);
        System.out.print("-------------------------------------------------------------------");
    }

}