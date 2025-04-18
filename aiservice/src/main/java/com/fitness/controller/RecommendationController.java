package com.fitness.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.model.Recommendation;
import com.fitness.service.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recommendations")
public class RecommendationController 
{
	private final RecommendationService recommendationService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Recommendation>> getUserRecommendations(@PathVariable String userId)
	{
		return ResponseEntity.ok(recommendationService.getRecommendations(userId));
	}
	
	@GetMapping("/activity/{activityId}")
	public ResponseEntity<Recommendation> getActivityRecommendation(@PathVariable String activityId)
	{
		return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
	}

}
