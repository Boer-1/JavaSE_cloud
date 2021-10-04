package com.mulUserCommuniSys.qqServer.service;


import com.mulUserCommuniSys.qqCommon.Message;
import com.mulUserCommuniSys.qqCommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServerConnectClientThread extends Thread{
    private HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThread.getHashMap();
    private Socket socket;
    private Message message;
    private Message response = new Message();

    public ServerConnectClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                message = (Message) ois.readObject();
                //服务器等着收消息，此时已进入二级列表，处理当下的消息
                if(message.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIENDS_INFO)){
                    dealOnlineInfo();
                }
                if(message.getMesType().equals(MessageType.MESSAGE_EXIT)){
                    System.out.println(message.getSender()+"退出系统~");
                    socket.close();
                    hashMap.remove(message.getSender());
                    break;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void dealOnlineInfo(){
        //得到除申请者之外的所有在线用户
        String sender = message.getSender();
        System.out.println(sender + "请求获取在线用户列表···");
        String content = "";
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            if(!iterator.next().equals(sender)){
                content += iterator.next() + ",";
            }
        }
        //准备消息
        response.setMesType(MessageType.MESSAGE_ONLINE_FRIENDS_INFO_RESPONSE);
        response.setContent(content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
