package com.shinrin.dao;

import com.shinrin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //查
    @Select("select * from mybatis.user")
    List<User> getUsers();
    //查
    //方法存在多个参数时，参数前面加上@Param("id")注解，仅基本类型
    @Select("select * from mybatis.user where id = #{id}")
    User getUserById(@Param("id") int id);
    //增
    @Insert("insert into mybatis.user(id,name,pwd) values(#{id}, #{name}, #{pwd})")
    int addUser(User user);
    //改
    @Update("update mybatis.user set name=#{name}, pwd=#{pwd} where id = #{id}")
    int updateUser(User user);
    //删
    @Delete("delete from mybatis.user where id = #{id}")
    int deleteUser(@Param("id") int id);

}
