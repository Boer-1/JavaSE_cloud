package com.mulUserCommuniSys.qqCommon;

public interface MessageType {
    //接口中定义一些常量，不同常量值，表示不同消息类型
    String MESSAGE_LOGIN_SUCCEED = "1";//登录成功
    String MESSAGE_LOGIN_FAIL = "2";//登录失败
    String MESSAGE_ONLINE_FRIENDS_INFO = "3";//拉取在线用户请求
    String MESSAGE_ONLINE_FRIENDS_INFO_RESPONSE = "4";//返回在线用户消息
    String MESSAGE_EXIT = "5";//用户退出系统
}
