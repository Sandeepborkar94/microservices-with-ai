package com.fitness.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fitness.model.Activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener
{
	
	@RabbitListener(queues = "activity.queue")
	public void processActivity(Activity activity)
	{
		log.info("Received activity message: {}", activity);
		
		/* 
		 	Process the activity message
		 	For example, save it to the database or perform some business logic
			activityService.saveActivity(activity);
		*/
		
		log.info("Processed activity message: {}", activity);
		log.info("Activity ID: {}", activity.getId());
		log.info("User ID: {}", activity.getUserId());
		log.info("Activity Type: {}", activity.getActivityType());
		log.info("Duration: {} minutes", activity.getDuration());
		log.info("Calories Burned: {}", activity.getCaloriesBurned());
		log.info("Start Time: {}", activity.getStartTime());
		log.info("Additional Metrics: {}", activity.getAdditionalMetrics());
		
		log.info("Activity processing completed.");
		
	}

}
