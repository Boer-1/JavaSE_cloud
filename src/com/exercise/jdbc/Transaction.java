package com.exercise.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
//将捕获得异常放大至包括自设异常才有效，此仅为测试
//实际运行所出错误，其异常捕获恰好
public class Transaction {
    public static void main(String[] args) {
        //准备sql
        String creat_table = "create table if not exists account (" +
                "id int primary key," +
                "name varchar(32) not null," +
                "deposit double)";
        PreparedStatement preStatement = null;
        //保存点   测试语句：int i = 1/0;
        Savepoint createTable_done = null;
        Savepoint insertData_done = null;
        //得到连接
        Connection connection = JDBCUtils.getConnection();
        try {
            //取消自动提交
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //建表
        try {
            preStatement = connection.prepareStatement(creat_table);
            preStatement.executeUpdate();
            createTable_done = connection.setSavepoint("createTable_done");
            System.out.println("createTable_done");
        } catch (Exception e) {
            try {
                //若建表有误，回滚起始位置
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //插入数据
        String insert = "insert into account values" +
                "(1,'张三',800)," +
                "(2,'罗翔',1000)";
        try {
            preStatement = connection.prepareStatement(insert);
            preStatement.executeUpdate();
            insertData_done = connection.setSavepoint("insertData_done");
            System.out.println("insertData_done");
        } catch (Exception e) {
            try {
                //插入数据有误，回滚到建完表时
                connection.rollback(createTable_done);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //transaction
        String empSql = "update account set deposit = deposit + 100 where id = 1";
        String bossSql = "update account set deposit = deposit - 100 where id = 2";
        try {
            preStatement = connection.prepareStatement(empSql);
            preStatement.executeUpdate();
            preStatement = connection.prepareStatement(bossSql);
            preStatement.executeUpdate();
            System.out.println("transaction_done");
        } catch (Exception e) {
            try {
                //若事务有误，回滚到插入完数据时
                connection.rollback(insertData_done);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //提交
        try {
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("commitSuccess~");
        //关闭资源
        JDBCUtils.close(null,preStatement,connection);
    }
}
