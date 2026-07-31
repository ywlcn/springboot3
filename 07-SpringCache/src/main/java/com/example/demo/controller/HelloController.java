package com.example.demo.controller;

import com.example.demo.service.AddressBookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    AddressBookDataService addressBookDataService;

    @GetMapping("/")
    public String index(Model model) {
        // modelに値を設定し、JSP側で${message}として参照できるようにする
        model.addAttribute("message", "Welcome to Spring Boot JSP!");

        addressBookDataService.getAddress(1);

        // JSPファイル名（プレフィックスとサフィックスを除いた部分）を返す
        // ここでは /WEB-INF/jsp/hello.jsp が呼ばれる
        return "hello";
    }
}