package com.exercise.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_test {
    public static void main(String[] args) throws SQLException {
        /**
         * 前置
         * 将mysql.jar拷贝至一目录(src同级)
         * add to project,添加到项目
         *
         */
        //1,注册驱动
        Driver driver = new Driver();//创建driver对象

        //2,得到连接
        /**
         * jdbc:mysql://
         * 规定好的协议
         * 然后就是主机地址，端口，数据库名
         * '172.16.188.74'
         */
        String url = "jdbc:mysql://localhost:3306/db_4323";
        //将用户名和密码放入到properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");//user固定
        properties.setProperty("password","200139");//password固定
        Connection connect = driver.connect(url,properties);//得到的连接，connect

        //3,执行sql
        String sql = "insert into actor values(null,'朴树','男','1978-11-2','16894235478')";
        //statement 用于执行静态SQL语句，并返回其生成的结果的对象
        //存在SQL注入问题，实际开发不用
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//此句是dml，返回的是影响行数
        //显式结果
        System.out.println(rows > 0? "success":"failure");

        //4,关闭连接资源
        statement.close();
        connect.close();
    }
}
