package com.fitness.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig
{
	// This class is used to configure the WebClient bean
	// It is currently empty, but can be used to customize the WebClient if needed
	// For example, you can add default headers, error handling, etc.
	
	@Bean
	@LoadBalanced
	WebClient.Builder webClientBuilder()
	{
		return WebClient.builder();
	}
	
	@Bean
	WebClient userServiceWebClient(WebClient.Builder webClientBuilder)
	{
		// This method creates a WebClient bean for the user service
		// It uses the WebClient.Builder to build the WebClient with a base URL
		return webClientBuilder.baseUrl("http://user-service").build();
	}
	

}
