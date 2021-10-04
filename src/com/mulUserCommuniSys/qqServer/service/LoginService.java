package com.mulUserCommuniSys.qqServer.service;

import com.mulUserCommuniSys.qqCommon.User;

import java.util.Iterator;

public class LoginService {
    public boolean checkUser_Pwd(User user){
        Iterator<String> iterator = UserTable.table.keySet().iterator();
        while (iterator.hasNext()){
            String vip = iterator.next();
            if(user.getUserId().equals(vip) &&
                    user.getPasswd().equals(UserTable.table.get(vip))){
                return true;
            }
        }
        return false;
    }
}
