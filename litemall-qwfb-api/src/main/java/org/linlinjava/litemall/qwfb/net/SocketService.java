
package org.linlinjava.litemall.qwfb.net;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.linlinjava.litemall.qwfb.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 * @author nickBi create on 2018/7/5.
 */
@Service
public class SocketService {
    private static final Logger logger = LoggerFactory.getLogger(SocketService.class);

    @Autowired
    private SocketIOServer server;

    private static Map<String, SocketIOClient> clientsMap = new HashMap<String, SocketIOClient>();

    @Autowired
    private MessageService messageService;

    /**
     * 添加connect事件，当客户端发起连接时调用，本文中将 clientid 与 sessionid 存入数据库 <br>
     * 方便后面发送消息时查找到对应的目标client,
     *
     * @param client
     */
    @OnConnect
    public void onConnect(SocketIOClient client) {
        String uuid = client.getSessionId().toString();
        clientsMap.put(uuid, client);
        messageService.clientConnect(uuid);
        logger.info("IP: " + client.getRemoteAddress().toString() + " UUID: " + uuid + " 设备建立连接");
    }

    /**
     * 添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
     */
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        String clientId = client.getSessionId().toString();
        clientsMap.remove(clientId);
        messageService.clientDisconnect(clientId);
        logger.info("IP: " + client.getRemoteAddress().toString() + " UUID: " + clientId + " 设备断开连接");
    }

    @OnEvent(value = "login")
    public void login(SocketIOClient client, String data, AckRequest request) {
        Integer userId = messageService.login(client.getSessionId().toString(), data);
        logger.info("用户登录 " + data);
        client.sendEvent(MessageKey.Key_Login_Result, userId);
    }

    @OnEvent(value = "logout")
    public void logout(SocketIOClient client, String data, AckRequest request) {
        messageService.logout(client.getSessionId().toString(), data);
        logger.info("用户登出 " + data);
    }

    @OnEvent(value = "add user")
    public void addUser(SocketIOClient client, String data, AckRequest request) {
        logger.info("用户进入" + data);

        Map<String, Integer> result = new HashMap<>();
        result.put("numUsers", clientsMap.size());
        client.set("userName", data);

        client.sendEvent("login", result);
    }

    @OnEvent(value = "new message")
    public void newMessage(SocketIOClient client, String data, AckRequest request) {
        logger.info("用户进入" + data);

        Map<String, String> result = new HashMap<>();
        result.put("username", client.get("userName"));
        result.put("message", data);

        server.getRoomOperations("chatroom1").sendEvent("new message", result);
    }

    @OnEvent(value = "typing")
    public void typing(SocketIOClient client, Integer data, AckRequest request) {
        logger.info("用户进入" + data);
    }

    @OnEvent(value = "stop typing")
    public void stopTyping(SocketIOClient client, Integer data, AckRequest request) {
        logger.info("用户进入" + data);
    }

    public void sendMessageToClient(String clientId, String eventType, String message, AckCallback<?> ackCallback) {
        SocketIOClient client = server.getClient(UUID.fromString(clientId));
        if (ackCallback != null) {
            client.sendEvent(eventType, ackCallback, message);
        } else {
            client.sendEvent(eventType, message);
        }
    }

    /**
     * 给所有连接客户端推送消息
     *
     * @param eventType
     *            推送的事件类型
     * @param message
     *            推送的内容
     */
    public void sendMessageToAllClient(String eventType, String message) {
        Collection<SocketIOClient> clients = server.getAllClients();
        for (SocketIOClient client : clients) {
            client.sendEvent(eventType, message);
        }
    }

}