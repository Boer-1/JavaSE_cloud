package com.exercise.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Con_FiveType {
    @Test
    public void connect1() throws SQLException {
        //属于静态加载，灵活性差，依赖强
        Driver driver = new Driver();//创建driver对象

        String url = "jdbc:mysql://localhost:3306/db_4323";
        //将用户名和密码放入到properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");//user固定
        properties.setProperty("password","200139");//password固定
        Connection connect = driver.connect(url,properties);//得到的连接，connect

        System.out.println(connect);
        connect.close();
    }
    @Test
    public void connect2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载driver类，动态加载，更加地灵活，减少依赖
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db_4323";
        //将用户名和密码放入到properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");//user固定
        properties.setProperty("password","200139");//password固定
        Connection connect = driver.connect(url,properties);//得到的连接，connect

        System.out.println(connect);
        connect.close();
    }
    @Test
    public void connect3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用DriverManager 替代Driver 进行统一管理
        //不必创建properties;具有更好的扩展性
        //创建url，user，password
        String url = "jdbc:mysql://localhost:3306/db_4323";
        String user = "root";
        String password = "200139";
        //还是先用反射拿到driver，DriverManager得持有一个driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        DriverManager.registerDriver(driver);
        //获得connection
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
        connection.close();
    }
    @Test
    public void connect4() throws ClassNotFoundException,SQLException {
        //该方法不必registerDriver(driver)注册，故也省去了用反射获得实例的步骤
        //创建url，user，password
        String url = "jdbc:mysql://localhost:3306/db_4323";
        String user = "root";
        String password = "200139";

        //使用反射加载driver类时，底层静态代码块完成注册
        Class.forName("com.mysql.jdbc.Driver");//jdk1.5后省去该语句亦能顺利执行，但建议写上
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
        connection.close();
    }
    @Test
    //使用最多，推荐方法,使用配置文件，连接数据库更灵活
    public void connect5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
        connection.close();
    }
}
