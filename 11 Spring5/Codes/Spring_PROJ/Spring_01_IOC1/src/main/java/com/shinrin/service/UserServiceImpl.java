package com.shinrin.service;

import com.shinrin.dao.UserDao;
import com.shinrin.dao.UserDaoImpl;
import com.shinrin.dao.UserDaoMysqlImpl;
import com.shinrin.dao.UserDaoOracleImpl;
import jdk.nashorn.internal.ir.CallNode;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    //以往方式：需求改变，需要在此修改源码
    //private UserDao userDao = new UserDaoImpl();
    //private UserDao userDao = new UserDaoMysqlImpl();
    //private UserDao userDao = new UserDaoOracleImpl();

    //注入方式：通过set接口实现
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
