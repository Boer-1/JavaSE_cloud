package com.mulUserCommuniSys.qqServer.service;

import java.util.concurrent.ConcurrentHashMap;

public class UserTable {
    public static ConcurrentHashMap<String,String> table = new ConcurrentHashMap<>();
    static {
        table.put("111","123");
        table.put("222","123");
        table.put("333","123");
        table.put("444","123");
        table.put("555","123");
    }
}
