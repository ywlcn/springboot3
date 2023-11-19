package com.sample.rest.server;

import com.sample.demo.service.CityService;
import com.sample.dto.City;
import com.sample.dto.DemoErrorResponse;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Observed(name = "RestServerController")
@RestController
@RequestMapping("/restServer")
@ResponseBody
public class RestServerController {

    Logger loger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityService cityService;

    @GetMapping("/showCities")
    public List<City> showCities() {
        List<City> cities = cityService.findAll();
        return cities;
    }

}