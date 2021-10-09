package com.exercise.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class PreStatement_ {
    public static void main(String[] args) throws Exception {
        // ↓ 套路 ↓
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        // ↑ 套路 ↑
        //创建admin表
        String createTable = "create table if not exists admin " +
                "(id int primary key," +
                "name varchar(32) not null," +
                "pwd varchar(32))";
        //添加5条记录
        String insertSql = "insert into admin values(? ,?,?)";
        PreparedStatement preStatement = connection.prepareStatement(insertSql);
        preStatement.executeUpdate(createTable);
        for(int i = 1;i <= 5 ;i++ ){
            preStatement.setInt(1,i);
            preStatement.setString(2,"Tom"+i);
            preStatement.setString(3,i+"");
            preStatement.executeUpdate();
        }
        //TODO: 暂未知，只得再建个preStatement
        //修改Tom1的用户名
        String updateName = "update admin set name = ? where name = ?";
        PreparedStatement preStatement1 = connection.prepareStatement(updateName);

        preStatement1.setString(1,"Tom1");
        preStatement1.setString(2,"king");
        //删除一条记录
        String deleteSql = "delete from admin where id = ?";
        PreparedStatement preStatement2 = connection.prepareStatement(deleteSql);
        preStatement2.setInt(1,2);
        preStatement2.executeUpdate();
        //查询全部记录
        //喵的，少个逗号
        String selectSql = "select id,name, pwd from admin";
        PreparedStatement preStatement3 = connection.prepareStatement(selectSql);
        ResultSet resultSet = preStatement3.executeQuery();
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            String string1 = resultSet.getString(3);
            System.out.println(anInt + "\t" + string + "\t" + string1);
        }
        //关闭资源.....喵的，可能都得关
        resultSet.close();
        preStatement.close();
        connection.close();
    }
}
