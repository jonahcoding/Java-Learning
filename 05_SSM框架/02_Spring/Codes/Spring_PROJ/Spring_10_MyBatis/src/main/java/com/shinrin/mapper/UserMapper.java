package com.shinrin.mapper;

import com.shinrin.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
}