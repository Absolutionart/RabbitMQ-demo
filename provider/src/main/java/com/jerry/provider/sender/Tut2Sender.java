package com.jerry.provider.sender;

import jakarta.annotation.Resource;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.concurrent.atomic.AtomicInteger;

public class Tut2Sender {

	@Resource
	private RabbitTemplate template;

	@Resource
	private Queue workQueue;

	AtomicInteger dots = new AtomicInteger(0);

	AtomicInteger count = new AtomicInteger(0);

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {
		StringBuilder builder = new StringBuilder("Hello");
		if (dots.incrementAndGet() == 4) {
			dots.set(1);
		}
		for (int i = 0; i < dots.get(); i++) {
			builder.append('.');
		}
		builder.append(count.incrementAndGet());
		String message = builder.toString();
		template.convertAndSend(workQueue.getName(), message);
		System.out.println(" [x] Sent '" + message + "'");
	}

}