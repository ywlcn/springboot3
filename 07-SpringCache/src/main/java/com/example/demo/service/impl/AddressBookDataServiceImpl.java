package com.example.demo.service.impl;

import com.example.demo.dao.dto.CityEntity;
import com.example.demo.dao.mapper.CityMapper;
import com.example.demo.service.AddressBookDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AddressBookDataServiceImpl implements AddressBookDataService {

    @Autowired
    CityMapper cityMapper;

    Logger logger = LoggerFactory.getLogger(AddressBookDataServiceImpl.class);

    @Cacheable(
            value = "city",
            key = "#id",
            cacheManager = "cacheManager")
    public CityEntity getAddress(int id) {

        logger.warn("AddressBookDataServiceImpl#getAddress(" + id + ")");

        return cityMapper.getCity(id);

    }


}
