package com.mulUserCommuniSys.qqServer.service;

import java.util.HashMap;

public class ManageServerConnectClientThread {
    private static HashMap<String,ServerConnectClientThread> hashMap = new HashMap<>();
    public static void addServerConnectClientThread(String id,ServerConnectClientThread thread){
        hashMap.put(id,thread);
    }
    public static ServerConnectClientThread getServerConnectClientThread(String id){
        return hashMap.get(id);
    }
    public static HashMap<String, ServerConnectClientThread> getHashMap() {
        return hashMap;
    }
    public static void removeThread(String userId){
        hashMap.remove(userId);
    }
}
