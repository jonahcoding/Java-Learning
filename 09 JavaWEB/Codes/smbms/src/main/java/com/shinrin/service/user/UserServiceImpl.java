package com.shinrin.service.user;

import com.shinrin.dao.BaseDao;
import com.shinrin.dao.user.UserDao;
import com.shinrin.dao.user.UserDaoImpl;
import com.shinrin.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    //业务层都会调用DAO层，故引入DAO层
    private final UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

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
    //此处报错com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure
    //原因未知。
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "1234567");
        System.out.println(admin.getUserPassword());
    }
}
