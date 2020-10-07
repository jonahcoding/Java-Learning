package com.shinrin.lesson3;
/**
 * 测试PrepareStatement（防止SQL注入）
 */

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestInsert {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils.getConnection();
            //区别：使用?占位符代替参数（此处以查找为例）
            String sql = "insert into users(id,`name`,`password`,`email`,`birthday`)value(?,?,?,?,?)";
            st = conn.prepareStatement(sql);//    预编译sql，不执行
            //手动为参数赋值
            st.setInt(1,4);
            st.setString(2,"ZOE");
            st.setString(3,"123456");
            st.setString(4,"zoe@qq.com");
            //获取当前时间
            //java.util.Date  date=new java.util.Date();
            //java.sql.Date  sqldate=new java.sql.Date(date.getTime());
            st.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("插入成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}