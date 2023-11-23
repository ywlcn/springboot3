package com.sample.rest.server;

import com.sample.business.service.CityService;
import com.sample.dto.City;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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