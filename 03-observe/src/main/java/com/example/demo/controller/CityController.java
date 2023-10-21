package com.example.demo.controller;

import com.example.demo.dto.City;
import com.example.demo.dto.DemoErrorResponse;
import com.example.demo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CityController {

    Logger loger = LoggerFactory.getLogger(this.getClass());

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping("/showCities")
    public ModelAndView showCities() {

        List<City> cities = cityService.findAll();

        loger.info(cities.toString());
        Map<String, Object> params = new HashMap<>();
        params.put("cities", cities);

        return new ModelAndView("showCities", params);
    }


    @RequestMapping("/showError")
    public ModelAndView showError() {

        int i = 0;
        i = 12 / i;

        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("showCities", params);
    }



    @ExceptionHandler(Exception.class)
    public DemoErrorResponse handleException(Exception exception) {
        return new DemoErrorResponse(exception);
    }


}