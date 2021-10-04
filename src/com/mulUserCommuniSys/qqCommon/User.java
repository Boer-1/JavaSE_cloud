package com.mulUserCommuniSys.qqCommon;

import java.io.Serializable;

public class User implements Serializable {
    //增强健壮性
    private static final long serialVersionUID = 1L;
    //用户ID/密码
    private String userId;
    private String passwd;

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }
    public User(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
