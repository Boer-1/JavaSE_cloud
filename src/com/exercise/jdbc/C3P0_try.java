package com.exercise.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0_try {
    public static void main(String[] args) throws Exception {
        //创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //从配置文件中得到连接信息
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //连接管理交由ComboPooledDataSource管理
        //赋予其取出的信息
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置comboPooledDataSource参数
        comboPooledDataSource.setInitialPoolSize(100);
        comboPooledDataSource.setMaxPoolSize(500);
        //核心方法，从DataSource接口实现
        Connection connection = comboPooledDataSource.getConnection();
        //Test
//        long start = System.currentTimeMillis();
//        c3p0_test(comboPooledDataSource);
//        long end = System.currentTimeMillis();
//        //耗时340ms
//        System.out.println("连接5000次mysql耗时 "+ (end - start) +" ms");
        //关闭资源
        System.out.println("done~");
        connection.close();
    }
    public static void c3p0_test(ComboPooledDataSource comboPooledDataSource) throws SQLException {
        //测试通过c3p0连接5000次mysql
        for(int i = 0;i < 5000;i++){
            Connection connection = comboPooledDataSource.getConnection();
            //....连接
            connection.close();
        }
    }
}
