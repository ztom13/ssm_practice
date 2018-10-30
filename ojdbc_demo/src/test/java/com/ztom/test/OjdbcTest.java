package com.ztom.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * author:ztom
 * date:2018/10/26 20:49
 */
public class OjdbcTest {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@10.211.55.6:1521:orcl";
    String username = "scott";
    String password = "tiger";
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    @Before
    public void init() throws Exception {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
    }

    @Test
    public void test() throws SQLException {
        String sql = "select * from emp";
        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("empno")+":"+rs.getString("ename"));
        }
    }

    @After
    public void close() throws SQLException {
        if (rs != null){
            rs.close();
        }
        if (pst != null){
            pst.close();
        }
        if(connection != null){
            connection.close();
        }
    }
}
