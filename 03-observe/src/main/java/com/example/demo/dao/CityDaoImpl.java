package com.example.demo.dao;

import com.example.demo.dto.City;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDaoImpl implements  CityDao{

    @Autowired
    CityMapper cityMapper;
    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<City> findAll() {

        return cityMapper.findAll();

//        String sql = "SELECT * FROM cities";
//
//        return jtm.query(sql, new BeanPropertyRowMapper<>(City.class));

    }
}
