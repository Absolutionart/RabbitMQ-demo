package com.jerry.consumer.config;

import com.jerry.consumer.receiver.Tut3Receiver;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FanoutConfig {

	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("tut.fanout");
	}

	private static class ReceiverConfig {

		@Bean
		public Queue fanoutQueue1() {
			return new Queue("fanout.queue1");
		}

		@Bean
		public Queue fanoutQueue2() {
			return new Queue("fanout.queue2");
		}

		@Bean
		public Binding binding1(FanoutExchange fanout,
		    Queue fanoutQueue1) {
			return BindingBuilder.bind(fanoutQueue1).to(fanout);
		}

		@Bean
		public Binding binding2(FanoutExchange fanout,
		    Queue fanoutQueue2) {
			return BindingBuilder.bind(fanoutQueue2).to(fanout);
		}

		@Bean
		public Tut3Receiver tut3Receiver() {
			return new Tut3Receiver();
		}
	}
}