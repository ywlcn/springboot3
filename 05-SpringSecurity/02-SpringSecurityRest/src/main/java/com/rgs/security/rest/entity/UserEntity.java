package com.rgs.security.rest.entity;

import lombok.Data;

@Data
public class UserEntity {
    Integer id;
    String userName;
    String password;
}