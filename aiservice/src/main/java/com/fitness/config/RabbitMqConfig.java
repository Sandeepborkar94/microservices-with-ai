package com.fitness.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig
{
	// RabbitMQ configuration can be added here
	// For example, you can define queues, exchanges, and bindings
	// using @Bean annotations or other configuration methods.

	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	
	//purpose: Define a queue for activity messages
	@Bean
	 Queue activityQueue()
	{
		return new Queue(queue, true);
	}
	
	@Bean
	DirectExchange activityExchange()
	{
		return new DirectExchange(exchange);
	}
	
	
	@Bean
	Binding activityBinding(Queue activityQueue, DirectExchange activityExchange)
	{
		return BindingBuilder.bind(activityQueue).to(activityExchange).with(routingKey);
	}
	
	
	
	//purpose: Define a queue for user messages
	@Bean
	 MessageConverter messageConverter()
	{
		// Configure a message converter if needed
		// For example, you can use Jackson2JsonMessageConverter for JSON serialization
		return new Jackson2JsonMessageConverter();
	}

}
