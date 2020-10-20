package com.shinrin.lesson4;
/**
 * 事务测试。
 */

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);//开始事务（关闭自动提交）
            String sql1 = "update account set money = money - 100 where name = 'A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            //int x = 1/0;  //出错回滚，不提交。

            String sql2 = "update account set money = money + 100 where name = 'B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            conn.commit();
            System.out.println("成功！");
        }catch (SQLException e){
            try{
                conn.rollback();    //此处显式定义，实则失败默认回滚。
            }catch (SQLException se){
                se.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
