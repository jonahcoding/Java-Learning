package com.shinrin.dao;

import com.shinrin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //通过ID查询用户
    User getUserById(int id);

    //插入一条用户信息
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //使用map插入一条用户信息
    int addUser2(Map<String,Object> map);

    //模糊查询
    List<User> getUserLike(String value);
}
