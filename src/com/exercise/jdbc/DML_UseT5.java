package com.exercise.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;
@SuppressWarnings("all")
//idea瞎指毛病，非得设置你的database
public class DML_UseT5 {
    public static void main(String[] args) throws Exception {
        //获得connect
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
        //创建news表
        String build_tab = "create table news (id int primary key,content tinytext)";
        statement.executeUpdate(build_tab);
        //添加5条数据

//        String insert = "insert into news values(1,'第一条')";
        for(int i =1;i <= 5;i++){
            statement.executeUpdate("insert into `news` values(" + i+ ",'第" + i +"条')");
        }
//        statement.executeUpdate(insert);
        //修改id=1的记录，改变content
        String update = "update `news` set content = 'changed~' where id = 1";
        statement.executeUpdate(update);
        //删除id=3的记录
        String delete = "delete from news where id = 3";
        statement.executeUpdate(delete);

        System.out.println("success~");
        statement.close();
        connection.close();
    }
}
