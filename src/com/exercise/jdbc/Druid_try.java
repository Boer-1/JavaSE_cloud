package com.exercise.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Druid_try {
    public static void main(String[] args) throws Exception {
        //加入Druid.jar
        //配置文件放在src目录下
        //创建properties对象，读取文件
        Properties properties = new Properties();
        properties.load(new FileReader("src\\druid.properties"));

        //创建Druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        Connection connection = dataSource.getConnection();
        long start = System.currentTimeMillis();
        druid_test(dataSource);
        long end = System.currentTimeMillis();
        //耗时432ms
        //注，当连接次数更大时，将与c3p0产生明显差距，效果更好
        System.out.println("连接5000次mysql耗时 "+ (end - start) +" ms");
        System.out.println("done~");

    }
    public static void druid_test(DataSource dataSource) throws SQLException {
        //测试通过druid连接5000次mysql
        for(int i = 0;i < 5000;i++){
            Connection connection = dataSource.getConnection();
            //....连接
            connection.close();
        }
    }
}
