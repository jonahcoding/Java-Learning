package com.shinrin.lesson5;

import com.shinrin.lesson2.utils.JdbcUtils;
import com.shinrin.lesson5.utils.JdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_C3P0.getConnection();
            //区别：使用?占位符代替参数（此处以查找为例）
            String sql = "insert into users(id,`name`,`password`,`email`,`birthday`)value(?,?,?,?,?)";
            st = conn.prepareStatement(sql);//    预编译sql，不执行
            //手动为参数赋值
            st.setInt(1,6);
            st.setString(2,"Kitty");
            st.setString(3,"123456");
            st.setString(4,"kitty@qq.com");
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
