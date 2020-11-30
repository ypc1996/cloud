package com.example.provider.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;

/**
 * @author yangpengcheng
 * @ClassName RedisSubscribeListener
 * @Description:
 * @date 2020/11/1014:33
 */
@Component
public class RedisSubscribeListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //webSocket客户端会话对象
    private Session session;

    /**
     * 接收发布者消息
     * @param message
     * @param bytes
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = new String(message.getBody());
        logger.info("[{}]主题发布：{}", new String(bytes), msg);
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                logger.error("[redis监听器]发布消息异常：{}", e);
            }
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
