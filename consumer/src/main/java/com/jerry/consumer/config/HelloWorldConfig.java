package com.jerry.consumer.config;

import com.jerry.consumer.receiver.Tut1Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HelloWorldConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello.queue");
    }

    @Bean
    public Tut1Receiver tut1Receiver() {
        return new Tut1Receiver();
    }
}