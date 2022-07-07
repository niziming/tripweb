package cn.zm.common.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ws 服务端
 */
@Component
@Slf4j
@ServerEndpoint("/ws")
public class WebsocketServer {

    /**
     * 存放所有在线的客户端
     */
    public static Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        //将新用户存入在线的组
        clients.put(session.getId(), session);
        log.info("ID:{}连接-目前连接{}", session.getId(), clients.keySet().toArray(new String[0]));
    }

    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {
        //将掉线的用户移除在线的组里
        clients.remove(session.getId());
        log.info("ID:{}断开-目前连接{}", session.getId(), Arrays.toString(clients.keySet().toArray(new String[0])));
    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("收到:{}", message);
    }

    /**
     * 群发消息
     * @param message 消息内容
     */
    private void sendAll(String message) {
        for (Map.Entry<String, Session> sessionEntry : clients.entrySet()) {
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }
    }
}
