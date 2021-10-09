package com.exercise.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class ResultSet_ {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String password = properties.getProperty("password");
        Class.forName(driver);
        Connection connection = (Connection) DriverManager.getConnection(url, user, password);
        //准备执行sql
        Statement statement = (Statement) connection.createStatement();
        String sql = "select id,name,sex from actor";
        ResultSet resultSet = statement.executeQuery(sql);
        //用while取出数据
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            String string1 = resultSet.getString(3);
            System.out.println(anInt + "\t" + string + "\t" + string1);
        }
        //关闭资源，结果集也要关
        resultSet.close();
        statement.close();
        connection.close();
    }
}
