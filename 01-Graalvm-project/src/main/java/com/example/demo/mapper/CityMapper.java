package com.example.demo.mapper;

import com.example.demo.dto.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

// https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start-for-building-native-image
@Mapper
public interface CityMapper {

    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);

    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City findById(long id);

    @Select( "SELECT * FROM cities")
    List<City> findAll();
}


