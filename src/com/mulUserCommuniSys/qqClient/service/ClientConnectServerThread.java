package com.mulUserCommuniSys.qqClient.service;


import com.mulUserCommuniSys.qqCommon.Message;
import com.mulUserCommuniSys.qqCommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    //每个线程都需要持有一个 socket 来跟服务器通信
    private Socket socket;
    private Message message = new Message();
    //线程创建时，给赋一个 socket
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //线程一直在后台通信服务器，收（发）信息
        while (true){
            System.out.println("客户端线程，等待接受服务器消息···");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果没收到，将阻塞在此
                message = (Message) ois.readObject();
                //TODO: 使用服务器回复的 message
                if(message.getMesType().equals(MessageType.MESSAGE_LOGIN_FAIL)){
                }
                if(message.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIENDS_INFO_RESPONSE)){
                    dealOnlineResponse();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void dealOnlineResponse(){
        String content = message.getContent();
        //TODO: 解析消息
        String[] split = content.split(",");
        for(String str:split){
            System.out.println(str + "在线空闲中");
        }
    }

    //可能将来要用线程的 socket ,暂时未知
    public Socket getSocket() {
        return socket;
    }
}
