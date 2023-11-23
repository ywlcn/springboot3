package com.sample.business.service.impl;

import com.sample.business.dao.CityDao;
import com.sample.business.service.CityService;
import com.sample.dto.City;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    @Observed(name = "user.name",
            contextualName = "getting-user-name",
            lowCardinalityKeyValues = {"userType", "userType2"})
    public List<City> findAll() {
        return cityDao.findAll();
    }
}