package com.jerry.provider.config;

import com.jerry.provider.sender.Tut2Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class WorkConfig {

    @Bean
    public Queue workQueue() {
        return new Queue("work.queue");
    }

    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }
}
