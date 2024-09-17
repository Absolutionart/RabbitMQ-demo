package com.jerry.consumer.config;

import com.jerry.consumer.receiver.Tut2Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class WorkConfig {
    @Bean
    public Queue workQueue() {
        return new Queue("work.queue");
    }

    private static class ReceiverConfig {

        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }
}
