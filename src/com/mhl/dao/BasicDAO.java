package com.mhl.dao;


import com.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//包含，dml操作，查询多行，单行，单行单列方法
//泛型，可套用多个domain
public class BasicDAO<T> {
    //dbUtils-->方便数据操作
    private QueryRunner qr = new QueryRunner();

    //通用dml方法;传入sql语句，及可能有的多个参数
    public int update(String sql ,Object... parameters){
        //在‘外边’定义是为了作用域，connection还需在finally处关闭
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            //返回受影响行数
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            //抛出运行异常
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     *
     * @param sql sql语句
     * @param clazz 需用反射完成封装，故要传入类的class对象
     * @param parameters sql语句，若有？，则在parameters处添值
     * @return 指定泛型，将来返回的是ArrayList集合
     */
    //查询得到多行记录
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            //抛出运行异常
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行记录
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            //抛出运行异常
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    //查询单行单列
    public Object queryScalar(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            Object query = qr.query(connection, sql, new ScalarHandler(), parameters);
            return query;
        } catch (SQLException e) {
            //抛出运行异常
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
