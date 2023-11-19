package com.sample.demo.dao.mapper;

import com.sample.dto.City;
import com.sample.dto.District;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DistrictMapper {

    @Insert("INSERT INTO district (name, cityId) VALUES(#{name}, #{cityId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(District district);

    @Select("SELECT * FROM district WHERE id = #{id}")
    District findById(int id);

    @Select( "SELECT * FROM district WHERE cityId = #{id}")
    List<District> findByCity(int id );

}


