package com.shinrin.dao;

import com.shinrin.pojo.User;
import com.shinrin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        //一、获取sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //二、执行SQL
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //三、关闭sqlSession
        sqlSession.close();
    }
}
