package com.sample.demo.dao.impl;

import com.sample.demo.dao.CityDao;
import com.sample.dto.City;
import com.sample.demo.dao.mapper.CityMapper;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Observed(name = "CityDaoImpl")
@Component
public class CityDaoImpl implements CityDao {

    @Autowired
    CityMapper cityMapper;
    @Override
    public List<City> findAll() {

        try{
            return cityMapper.findAll();
        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<City>() ;
        }
    }
}
