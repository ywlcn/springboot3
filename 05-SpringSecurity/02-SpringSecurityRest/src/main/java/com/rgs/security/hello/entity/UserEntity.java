package com.rgs.security.hello.entity;

import lombok.Data;

@Data
public class UserEntity {
    Integer id;
    String userName;
    String password;
}