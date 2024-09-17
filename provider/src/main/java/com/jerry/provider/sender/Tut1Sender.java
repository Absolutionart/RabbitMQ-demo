// Sender
package com.jerry.provider.sender;

import jakarta.annotation.Resource;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

public class Tut1Sender {

    @Resource
    private RabbitTemplate template;

    @Resource
    private Queue helloQueue;

//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(helloQueue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}