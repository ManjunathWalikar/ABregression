package com.sprint.qa.util;

import com.sprint.qa.base.TestBase;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;

public class ClientSqlDriver extends TestBase {
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet resultSet = null;

    public ClientSqlDriver() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(prop.getProperty("db_url"));
        dataSource.setUser(prop.getProperty("db_username"));
        dataSource.setPassword(prop.getProperty("db_password"));
        try{
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void connection_test(String query) throws SQLException {
        pstmt=connection.prepareStatement(query);
        resultSet=pstmt.executeQuery();
        while (resultSet.next()){
            System.out.println("result: "+resultSet.getString(1));
        }
    }

    public void update_query(int days) throws SQLException {
        pstmt = connection.prepareStatement("Update dbo.Subscriptions set EndDate= DATEADD(DAY, ?, GetDate())\n" +
                "WHERE Status=4 AND SubscriptionNumber="+prop.getProperty("db_reg04_subNum_1")+";");
        pstmt.setInt(1,days);
        int i=pstmt.executeUpdate();
        System.out.println("value executed: "+i);
    }

    public ResultSet execute_query(String query) throws SQLException {
        pstmt=connection.prepareStatement(query);
        resultSet=pstmt.executeQuery();
        return resultSet;
    }
}
