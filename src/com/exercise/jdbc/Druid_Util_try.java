package com.exercise.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Druid_Util_try {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String search = "select id,name ,deposit from account";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(search);
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            double aDouble = resultSet.getDouble(3);
            System.out.println(anInt +"\t"+string+"\t"+aDouble);
        }
        JDBCUtilsByDruid.close(resultSet,statement,connection);
    }
}
