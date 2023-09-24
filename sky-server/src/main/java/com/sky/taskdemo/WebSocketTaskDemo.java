package com.sky.taskdemo;

import com.sky.websocket.WebSocketServerDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author awl
 * @date 2023/9/24 22:45
 */
@Component
public class WebSocketTaskDemo {

    @Autowired
    private WebSocketServerDemo webSocketServerDemo;

    /**
     * 通过WebSocket每隔5秒向客户端发送消息
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMessageToClient() {
        webSocketServerDemo.sendToAllClient("这是来自服务端的消息：" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
    }
}
