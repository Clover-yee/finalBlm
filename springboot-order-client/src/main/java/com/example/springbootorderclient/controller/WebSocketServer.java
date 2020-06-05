package com.example.springbootorderclient.controller;

import com.example.springbootblmapi.service.SmShopService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@ServerEndpoint("/websocket/{shopId}") //此注解相当于设置访问URL
@Slf4j
public class WebSocketServer {
    private static SmShopService service;

    @Reference
    public void setMapper(SmShopService service) {
        WebSocketServer.service = service;
    }

    private Session session;
    private static final ConcurrentMap<Integer, WebSocketServer> webSockets = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="shopId")Integer shopId) {
        this.session = session;
        webSockets.put(shopId, this);
        modifyShopState(shopId, "在线");
        log.info("websocket新的连接，总数为:"+webSockets.size());
    }

    @OnClose
    public void onClose() {
        Integer shopId = null;
        for (Integer key : webSockets.keySet()) {
            if (webSockets.get(key) == this)
                shopId = key;
        }
        if (shopId != null) {
            webSockets.remove(shopId);
            modifyShopState(shopId, "离线");
        }
//        new SmShopController().modifyShopState();
        log.info("websocket连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("websocket收到客户端消息:"+message);
    }

    public static void sendAllMessage(String message) {
        for(WebSocketServer webSocket : webSockets.values()) {
            log.info("websocket广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendMessageToShop(Integer shopId, String msg) {
        Session session = webSockets.get(shopId).session;
        if (session != null)
            session.getAsyncRemote().sendText(msg);
        else
            log.info("店家未开启,无法发送信息(可能存在其他逻辑错误)");
    }

    private void modifyShopState(int shopId, String state){
        service.modifyShopState(shopId, state);
    }

}
