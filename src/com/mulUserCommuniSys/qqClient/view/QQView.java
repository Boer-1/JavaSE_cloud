package com.mulUserCommuniSys.qqClient.view;

import com.mulUserCommuniSys.qqClient.service.Exit;
import com.mulUserCommuniSys.qqClient.service.GetOnlineUser;
import com.mulUserCommuniSys.qqClient.service.UserClientService;
import com.mulUserCommuniSys.utils.Utility;

public class QQView {
    private boolean loop = true;
    private String key = "";//接受用户的键盘输入
    //完成登录和注册服务而设置成员变量，大胆点：惦记方法用着方便--聚合
    private UserClientService userClientService = new UserClientService();
    private GetOnlineUser getOnlineUser;

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    //显示主菜单
    private void mainMenu(){

        while (loop){
            System.out.println("========欢迎登陆网络通信系统=======");
            System.out.println("\t\t 1 登陆系统");
            System.out.println("\t\t 9 退出系统");

            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            //根据用户的输入，来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);

                    if(userClientService.checkUser(userId,pwd)) {//如果验证通过
                        System.out.print("======欢迎（用户 " + userId + " ）=======");
                        //进入到二级菜单
                        while (loop){
                            System.out.println("\n=======网络通信系统二级菜单（用户 " + userId + " ）=======");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    getOnlineUser = new GetOnlineUser(userId);
                                    getOnlineUser.sendRequest();
                                    System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    new Exit().exit(userId);
                                    loop = false;
                                    break;
                            }
                        }

                    }else {//验证不通过，登陆失败
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
        System.out.println("客户端退出系统····");
    }

}
