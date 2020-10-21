package com.smbms.dao.user;

import com.smbms.pojo.User;

import java.sql.Connection;

public interface UserDao {
    /**
     * 通过userCode获取User
     * @param connection
     * @param userCode
     * @return
     * @throws Exception
     */
    public User getLoginUser(Connection connection, String userCode)throws Exception;
}