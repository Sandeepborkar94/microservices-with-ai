package com.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.model.Recommendation;
import com.fitness.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService
{
	private final RecommendationRepository recommendationRepository;

	public List<Recommendation> getRecommendations(String userId) 
	{
		return recommendationRepository.findByUserId(userId);
	}

	public Recommendation getActivityRecommendation(String activityId) 
	{
		return recommendationRepository.findByActivityId(activityId)
				.orElseThrow(() -> new RuntimeException("Recommendation not found for activity ID: " + activityId));
	}

}
