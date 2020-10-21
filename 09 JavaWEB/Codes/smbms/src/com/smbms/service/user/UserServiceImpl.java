package com.smbms.service.user;

import com.smbms.dao.BaseDao;
import com.smbms.dao.user.UserDao;
import com.smbms.dao.user.UserDaoImpl;
import com.smbms.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class UserServiceImpl implements UserService{

    //业务层都会调用DAO层，故引入DAO层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection, userCode);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("liming", "1234567");
        System.out.println(admin.getUserPassword());
    }
}
