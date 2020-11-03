package com.shinrin.dao;

import com.shinrin.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UsersMapper {

    //通过ID查询用户
    Users queryUserById(@Param("id") int id);

    void updateUser(Users user);

}