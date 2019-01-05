package com.cdl.demo.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/api/websocket/{userId}")
@Component
public class MyWebSocket {

    private static ConcurrentHashMap<Integer, MyWebSocket> webSocketMap = new ConcurrentHashMap<Integer, MyWebSocket>();
    private Session session;
    private Integer userId;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Integer userId) {
        this.session = session;
        this.userId = userId;
        webSocketMap.put(userId, this);
        System.out.println("有新连接加入！用户id是："+ userId + "当前在线人数：" + webSocketMap.size());
    }

    @OnClose
    public void onClose() {
        webSocketMap.remove(userId);  //从map中删除
        System.out.println("有一连接关闭！当前在线人数为" + webSocketMap.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("来自客户端的消息:" + message);
        try {
            sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) throws IOException {
        JSONObject chat = JSON.parseObject(message);

        if (chat.get("toClassId").equals("") || chat.get("toClassId") == null) {
            Integer toUserId = Integer.parseInt(chat.get("toUserId").toString());
            MyWebSocket to = webSocketMap.get(toUserId);
            if (to != null) {
                to.session.getBasicRemote().sendText(message);
            }
        } else {
            Integer toClassId = Integer.parseInt(chat.get("toClassId").toString());
        }
    }
}