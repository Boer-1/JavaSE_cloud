package com.mulUserCommuniSys.qqClient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {
    //通过HashMap管理多个线程，K-V：用户-线程（为什么是用户，因为咱是多用户通信）
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //然后就是提供的方法
    //将某个线程加入到集合
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread ){
        hm.put(userId,clientConnectServerThread);
    }
    //得到 userId 对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }


}
