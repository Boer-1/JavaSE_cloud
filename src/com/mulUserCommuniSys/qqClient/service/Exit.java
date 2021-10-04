package com.mulUserCommuniSys.qqClient.service;

import com.mulUserCommuniSys.qqCommon.Message;
import com.mulUserCommuniSys.qqCommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Exit {
    public void exit(String userId){
        Socket socket = ManageClientConnectServerThread.getClientConnectServerThread(userId).getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_EXIT);
            message.setSender(userId);
            oos.writeObject(message);
            System.out.println(userId + "已退出~");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
