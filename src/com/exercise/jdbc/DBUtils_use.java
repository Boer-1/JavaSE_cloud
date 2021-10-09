package com.exercise.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_use {
    //使用apache-DBUtils + druid完成对表的crud
    //-------------------------三种搜索-------------------------
    @Test
    //多行多列/多条记录/结果集：new BeanListHandler<>(Actor.class)
    public void testQueryMany() throws SQLException {
        //得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建queryRunner  (DBUtils ,引jar包)
        QueryRunner queryRunner = new QueryRunner();

        //执行相关方法，返回ArrayList结果集
        String select = "select * from actor";
        //new BeanListHandler<>(Actor.class) 将resultSet -> Actor对象 -> ArrayList
        //底层通过反射机制，去获取Actor类的属性，进行封装
        List<Actor> query = queryRunner.query(connection, select, new BeanListHandler<>(Actor.class));
        for(Actor actor : query){
            System.out.println(actor);
        }
    }
    @Test
    //单行多列/一条记录：new BeanHandler<>(Actor.class)
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String select = "select * from actor where id = ?";
        Actor query = queryRunner.query(connection, select, new BeanHandler<>(Actor.class), 2);
        System.out.println(query);

        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    //单行单列/一个对象：new ScalarHandler()-----(of a quantity 量) having size but no direction
    public void testScaler() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String select = "select name from actor where id = ?";
        Object query = queryRunner.query(connection, select, new ScalarHandler(), 1);
        System.out.println(query);
        JDBCUtilsByDruid.close(null,null,connection);
    }
    //-------------------------三种搜索-------------------------
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String update = "update actor set name = ? where id = ?";
        //受影响行数
        int rows = queryRunner.update(connection, update, "至尊宝", 3);
        if(rows > 0){
            System.out.println("done");
        }else {
            System.out.println("做了可能也没做");
        }
        JDBCUtilsByDruid.close(null,null,connection);
    }

}
