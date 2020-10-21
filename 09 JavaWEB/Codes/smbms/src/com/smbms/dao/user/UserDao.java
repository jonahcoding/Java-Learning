package com.smbms.dao.user;

import com.smbms.pojo.User;

import java.sql.Connection;

public interface UserDao {
    //获取登录用户
    public User getLoginUser(Connection connection, String userCode) throws Exception;
}