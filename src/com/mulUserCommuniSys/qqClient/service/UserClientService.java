package com.mulUserCommuniSys.qqClient.service;

import com.mulUserCommuniSys.qqCommon.Message;
import com.mulUserCommuniSys.qqCommon.MessageType;
import com.mulUserCommuniSys.qqCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {
    //可能在该类多处用到 user 信息，故将其设置为成员变量--关联
    private User u = new User();
    //同理，将 Socket 做成成员属性
//    private Socket socket;
    //根据得到的 userId 和 pwd 到服务器去验证合法
    public boolean checkUser(String userId,String pwd){
        boolean tag = false;
        //创建 user 对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接到服务器，发送 u 对象
        try {
            Socket socket = new Socket(InetAddress.getByName("172.16.188.74"), 9999);
            //发送 user 对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            //读取服务器回复的 message 对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            //判断
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//验证登录成功,返回true
                //创建一个和服务器保持通信的线程，并用集合来管理
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //添加入集合
                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                tag = true;
            }else if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_FAIL)){
                System.out.println("");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tag;
    }
}
