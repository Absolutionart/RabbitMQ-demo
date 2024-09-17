package com.jerry.consumer.config;

import com.jerry.consumer.receiver.Tut4Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DirectConfig {

	@Bean
	public DirectExchange direct() {
		return new DirectExchange("tut.direct");
	}

	private static class ReceiverConfig {

		@Bean
		public Queue directQueue1() {
			return new Queue("direct.queue1");
		}

		@Bean
		public Queue directQueue2() {
			return new Queue("direct.queue2");
		}

		@Bean
		public Binding binding1a(DirectExchange direct,
		    Queue directQueue1) {
			return BindingBuilder.bind(directQueue1)
			    .to(direct)
			    .with("orange");
		}

		@Bean
		public Binding binding1b(DirectExchange direct,
		    Queue directQueue1) {
			return BindingBuilder.bind(directQueue1)
			    .to(direct)
			    .with("black");
		}

		@Bean
		public Binding binding2a(DirectExchange direct,
		    Queue directQueue2) {
			return BindingBuilder.bind(directQueue2)
			    .to(direct)
			    .with("green");
		}

		@Bean
		public Binding binding2b(DirectExchange direct,
		    Queue directQueue2) {
			return BindingBuilder.bind(directQueue2)
			    .to(direct)
			    .with("black");
		}

		@Bean
		public Tut4Receiver tut4Receiver() {
	 	 	return new Tut4Receiver();
		}
	}
}