package com.exercise.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3P0_fileUse {
    public static void main(String[] args) throws SQLException {
        //什么叫一步到位
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("db_4323");
        //获得连接
        Connection connection = comboPooledDataSource.getConnection();
        String insert = "insert into tabt_insert values('file')";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.executeUpdate();
        System.out.println("done~");
        connection.close();
    }
}
