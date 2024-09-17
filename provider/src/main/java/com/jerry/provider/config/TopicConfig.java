package com.jerry.provider.config;

import com.jerry.provider.sender.Tut5Sender;
import org.springframework.amqp.core.*;
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

	@Bean
	public Tut5Sender sender() {
		return new Tut5Sender();
	}

}