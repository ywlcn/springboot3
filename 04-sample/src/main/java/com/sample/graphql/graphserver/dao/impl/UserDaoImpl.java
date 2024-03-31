package com.sample.graphql.graphserver.dao.impl;

import com.sample.graphql.graphserver.dao.UserDao;
import com.sample.graphql.graphserver.dao.mapper.UserMapper;
import com.sample.graphql.graphserver.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<User> findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public Optional<List<User>> findAll() {
        return userMapper.findAll();
    }

}



