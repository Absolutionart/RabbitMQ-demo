package com.jerry.provider.config;

import com.jerry.provider.sender.Tut4Sender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
	}

	@Bean
	public Tut4Sender sender() {
		return new Tut4Sender();
	}
}