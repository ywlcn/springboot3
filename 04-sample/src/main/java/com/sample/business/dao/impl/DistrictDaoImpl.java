package com.sample.business.dao.impl;

import com.sample.business.dao.DistrictDao;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Component;

@Observed(name = "DistrictDaoImpl")
@Component
public class DistrictDaoImpl implements DistrictDao {

}
