package com.sample.graphql.server.service.impl;

import com.sample.dto.User;
import com.sample.graphql.server.dao.UserDao;
import com.sample.graphql.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao accountdao;

    @Override
    public Optional<User> findById(String accountId) {
        return accountdao.findById(accountId);
    }

    @Override
    public List<User> findALl() {
        return accountdao.findAll();
    }
}
