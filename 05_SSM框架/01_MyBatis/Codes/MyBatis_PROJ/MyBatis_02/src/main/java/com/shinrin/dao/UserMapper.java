package com.shinrin.dao;

import com.shinrin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询全部用户
    List<User> getUserList();

    //通过ID查询用户
    User getUserById(int id);

    //分页1
    List<User> getUserByLimit(Map<String, Integer> map);

    //分页2
    List<User> getUserByRowBounds();

}
