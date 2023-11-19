package com.sample.demo.controller;

import com.sample.dto.City;
import com.sample.dto.DemoErrorResponse;
import com.sample.demo.service.CityService;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Observed(name = "cityController")
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