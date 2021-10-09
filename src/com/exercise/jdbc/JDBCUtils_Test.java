package com.exercise.jdbc;

import java.sql.*;

public class JDBCUtils_Test {
    public static void main(String[] args) {
        //得到连接
        Connection connection = JDBCUtils.getConnection();
        //准备sql
        String update = "update actor set name = ? where id = ?";
        String select = "select id ,name ,borndate from actor";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //测试dml
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,"周星驰");
            preparedStatement.setInt(2,2);
            preparedStatement.executeUpdate();
            //测试结果集
            resultSet = preparedStatement.executeQuery(select);
            while (resultSet.next()){
                int anInt = resultSet.getInt(1);
                String string = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                System.out.println(anInt + "\t"+string+"\t\t"+date );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("success~");
        JDBCUtils.close(resultSet,preparedStatement,connection);
    }
}
