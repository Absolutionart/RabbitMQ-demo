package com.jerry.provider.config;

import com.jerry.provider.sender.Tut1Sender;
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
    public Tut1Sender tut1Sender() {
        return new Tut1Sender();
    }

}