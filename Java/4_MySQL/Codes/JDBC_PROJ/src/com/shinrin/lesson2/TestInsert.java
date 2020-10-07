package com.shinrin.lesson2;
/**
 * Jdbc测试。
 */

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql1 = "INSERT INTO users(id,name,password,email,birthday)" +
                    "VALUES(4,'ZOE','123456','zoe@qq.com','2020-01-04')";
            String sql2 = "DELETE FROM users WHERE id = 4;";
            String sql3 = "UPDATE users SET `name` = 'Jerrry',`email` = 'jerry@qq.com' WHERE id = 1;";
            String sql4 = "SELECT * FROM users WHERE id = 1;";
            int i = st.executeUpdate(sql1);     //增
//            int i = st.executeUpdate(sql2);   //删
//            int i = st.executeUpdate(sql3);   //改
            rs = st.executeQuery(sql4);   //查
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }

            if (i > 0){
                System.out.println("更新成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
