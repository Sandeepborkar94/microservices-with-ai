package com.fitness.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fitness.model.Activity;
import com.fitness.model.Recommendation;
import com.fitness.repository.RecommendationRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener
{
	private final ActivityAiService activityAiService;
	
	private final RecommendationRepository recommendationRepository;
	
	
	@RabbitListener(queues = "activity.queue")
	public void processActivity(Activity activity)
	{
		log.info("Received activity message: {}", activity);
//		log.info("generated recommendation: {}", activityAiService.generateRecommendation(activity));	
		
		/* 
		 	Process the activity message
		 	For example, save it to the database or perform some business logic
			activityService.saveActivity(activity);
		*/
		
		Recommendation recommendation = activityAiService.generateRecommendation(activity);
		
		recommendationRepository.save(recommendation);
		
		
	}

	
	
	
}
