package com.exercise.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_try {
    @Test
    public void batch_no() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String insert = "insert into tabt_insert values(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        long start = System.currentTimeMillis();
        for(int i = 0;i<5000;i++){
            preparedStatement.setString(1,i+"");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        //3420ms
        System.out.println("插入记录5000次耗时 "+ (end - start) +" ms");
        preparedStatement.close();
        connection.close();
    }
    @Test
    public void batch_use() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String insert = "insert into tabt_insert values(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        long start = System.currentTimeMillis();
        for(int i = 0;i<5000;i++){
            preparedStatement.setString(1,i+"");
            preparedStatement.addBatch();
            if((i + 1)%1000 == 0){//满1000批量执行
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();//清空
            }
        }
        long end = System.currentTimeMillis();
        //3462(无参数)---50(有参数rewriteBatchedStatements=true)
        System.out.println("插入记录5000次耗时 "+ (end - start) +" ms");
        preparedStatement.close();
        connection.close();
    }
}
