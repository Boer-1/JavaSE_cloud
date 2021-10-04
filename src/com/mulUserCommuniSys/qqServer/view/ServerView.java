package com.mulUserCommuniSys.qqServer.view;

import com.mulUserCommuniSys.qqCommon.Message;
import com.mulUserCommuniSys.qqCommon.MessageType;
import com.mulUserCommuniSys.qqCommon.User;
import com.mulUserCommuniSys.qqServer.service.LoginService;
import com.mulUserCommuniSys.qqServer.service.ManageServerConnectClientThread;
import com.mulUserCommuniSys.qqServer.service.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ServerView {
    private LoginService loginService = new LoginService();
//    private ManageServerConnectClientThread manageServerConnectClientThread = new ManageServerConnectClientThread();

    public static void main(String[] args) {new ServerView().serverView();}
    private void serverView(){
        //开服务器，接受消息并处理
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                System.out.println("服务器已启动，监听中···");
                Socket socket = serverSocket.accept();
                //得到输入流，接受用户登录所发User对象
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                //验证用户名密码正确与否,写个方法
                if (loginService.checkUser_Pwd(user)) {//用户名密码正确，登录成功
                    //回复登录成功信息
                    Message message = new Message();
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    //在服务器端打印登录信息
                    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    System.out.println(user.getUserId() + "于" + ft.format(new Date()) + "登录···");
                    //此时就该启动一个线程来跟用户通信
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket);
                    serverConnectClientThread.start();
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), serverConnectClientThread);
                } else {
                    System.out.println("@" + user.getUserId() + "~" + user.getPasswd() + "==>登录失败···");
                    Message message = new Message();
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
