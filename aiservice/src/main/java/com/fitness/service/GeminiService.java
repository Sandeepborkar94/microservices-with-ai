package com.fitness.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GeminiService 
{
	
//	@Value("${gemini.api.url}")
	private String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="; // Replace with actual URL
	
//	@Value("${gemini.api.key}")
	private String GEMINI_API_KEY = "AIzaSyC3vKNiKrlovcVxIitSP6_noXw4JoxiF5E"; // Replace with actual API key
	
	
	private final WebClient webClient;
	
	public GeminiService(WebClient.Builder webClientBuilder)
	{
		this.webClient = webClientBuilder.build();
	}
	
	
	/**
	 * This method sends a request to the Gemini API with the provided question and returns the answer.
	 * 
	 * @param question The question to be sent to the Gemini API.
	 * @return The answer received from the Gemini API.
	 * 
	 * 
	 * {
  "contents": [{
    "parts":[{"text": "Write a hello word in java"}]
    }]
   }
	 */
	
	
	public String getAnswer(String question) 
	{
		Map<String, Object> requestBody = Map.of(
				"contents", new Object[] {
						Map.of("parts", new Object[] {
								Map.of("text", question)
						})
				}
		);
		
		String response = webClient.post().uri(GEMINI_API_URL + GEMINI_API_KEY)
				.header("Content-Type", "application/json")
				.bodyValue(requestBody)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		return response;
	}

}
