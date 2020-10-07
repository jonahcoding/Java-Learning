package com.shinrin.lesson3;
/**
 * SQL注入测试
 */

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLInject {
    public static void main(String[] args) {
//        login("Teemo", "123456");
        login("'or'1=1","'or'1=1");  //注入
    }
    public static void login(String username, String password) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "select * from users where `name` = '" + username + "' and `password` = '" + password + "';" ;
            //标准SQL注入语句，username ="'' or '1=1'"，password ="'' or '1=1'
            //SELECT * FROM users WHERE `name` = '' or '1=1' AND `password` = '' or '1=1'"
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
