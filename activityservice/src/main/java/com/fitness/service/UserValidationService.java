package com.fitness.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService
{
	// This class is used to validate the user
	// It uses the WebClient to call the user service and check if the user is valid
	// It is currently empty, but can be used to implement the validation logic
	// For example, you can check if the user exists, if the user is active, etc.
	
	
	private final WebClient userServiceWebClient;
	
	public boolean isValidUser(String userId)
	{
		log.info("Validating user with ID: {}", userId);
		
		try
		{
			return userServiceWebClient.get()
				.uri("/api/users/{userId}/validate", userId)
				.retrieve()
				.bodyToMono(Boolean.class)
				.block();
		}
		catch (WebClientResponseException e)
		{
			if(e.getStatusCode() == HttpStatus.NOT_FOUND)
			{
				throw new RuntimeException("User not found" + userId);
			
			}else if(e.getStatusCode() == HttpStatus.BAD_REQUEST)
			{
				throw new RuntimeException("Invalid Request" + userId);
			}
			else
			{
				throw new RuntimeException("Error occurred while validating user");
			}
		}
	}
	
}
