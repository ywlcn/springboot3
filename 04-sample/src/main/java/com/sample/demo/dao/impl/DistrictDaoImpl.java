package com.sample.demo.dao.impl;

import com.sample.demo.dao.DistrictDao;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Component;

@Observed(name = "DistrictDaoImpl")
@Component
public class DistrictDaoImpl implements DistrictDao {

}
