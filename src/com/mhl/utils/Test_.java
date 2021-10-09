package com.mhl.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Test_ {
    @Test
    public void Uti_test(){
        System.out.println("1515313513");
        int i = Utility.readInt(2);
        System.out.println(i);
    }
    @Test
    public void JDBCU_test() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
