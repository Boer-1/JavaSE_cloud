package com.mulUserCommuniSys.qqClient.service;

import com.mulUserCommuniSys.qqCommon.Message;
import com.mulUserCommuniSys.qqCommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GetOnlineUser {
    private String userId;
    private ClientConnectServerThread clientConnectServerThread;
    private Socket socket;

    //能传进来一个userid
    public GetOnlineUser(String userId){
        //通过userId得到线程，再得到socket
        this.userId = userId;
        clientConnectServerThread =
                ManageClientConnectServerThread.getClientConnectServerThread(userId);
        socket = clientConnectServerThread.getSocket();
    }
    public void sendRequest(){
       //发送要人消息
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_ONLINE_FRIENDS_INFO);
        message.setSender(userId);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
