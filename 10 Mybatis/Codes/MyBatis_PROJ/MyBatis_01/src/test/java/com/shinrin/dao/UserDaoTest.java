package com.shinrin.dao;

import com.shinrin.pojo.User;
import com.shinrin.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void getUserListTest(){
        //获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行操作
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "LiQing", "654321"));
        if (res > 0) {
            System.out.println("插入数据成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4,"Jinx","987654"));
        if (res > 0) {
            System.out.println("修改数据成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);
        if (res > 0) {
            System.out.println("删除数据成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 4);
        map.put("password", 142857);
        int res = mapper.addUser2(map);
        if (res > 0) {
            System.out.println("插入数据成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //模糊查询
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("%e%");
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }
}
