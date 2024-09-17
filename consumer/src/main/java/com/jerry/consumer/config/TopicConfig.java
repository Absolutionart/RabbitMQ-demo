package com.jerry.consumer.config;

import com.jerry.consumer.receiver.Tut5Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

	@Bean
	public TopicExchange topic() {
		return new TopicExchange("tut.topic");
	}

	private static class ReceiverConfig {

		@Bean
		public Tut5Receiver tut5Receiver() {
	 	 	return new Tut5Receiver();
		}

		@Bean
		public Queue topicQueue1() {
			return new Queue("topic.queue1");
		}

		@Bean
		public Queue topicQueue2() {
			return new Queue("topic.queue2");
		}

		@Bean
		public Binding binding1a(TopicExchange topic,
		    Queue topicQueue1) {
			return BindingBuilder.bind(topicQueue1)
			    .to(topic)
			    .with("*.orange.*");
		}

		@Bean
		public Binding binding1b(TopicExchange topic,
		    Queue topicQueue1) {
			return BindingBuilder.bind(topicQueue1)
			    .to(topic)
			    .with("*.*.rabbit");
		}

		@Bean
		public Binding binding2a(TopicExchange topic,
		    Queue topicQueue2) {
			return BindingBuilder.bind(topicQueue2)
			    .to(topic)
			    .with("lazy.#");
		}

	}

}