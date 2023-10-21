package com.example.demo.service;

import com.example.demo.dao.CityDao;
import com.example.demo.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }
}