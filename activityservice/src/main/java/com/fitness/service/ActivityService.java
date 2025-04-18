package com.fitness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;
import com.fitness.model.Activity;
import com.fitness.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService
{
	private final ActivityRepository activityRepository;
	
	private final UserValidationService userValidationService;
	
	public ActivityResponse trackActivity(ActivityRequest request)
	{
		
		boolean isValidUser = userValidationService.isValidUser(request.getUserid());
		
		if(!isValidUser)
		{
			throw new RuntimeException("Invalid User"+request.getUserid());
		}
		
		Activity activity = Activity.builder()
				.userId(request.getUserid())
				.activityType(request.getActivityType())
				.duration(request.getDuration())
				.caloriesBurned(request.getCaloriesBurned())
				.startTime(request.getStartTime())
				.additionalMetrics(request.getAdditionalMetrics())
				.build();
		
		Activity savedActivity = activityRepository.save(activity);
				
		return mapToResponse(savedActivity);
		
	}
	
	private ActivityResponse mapToResponse(Activity activity)
	{
		ActivityResponse response = new ActivityResponse();
		
		response.setId(activity.getId());
		response.setUserId(activity.getUserId());
		response.setActivityType(activity.getActivityType());
		response.setDuration(activity.getDuration());
		response.setCaloriesBurned(activity.getCaloriesBurned());
		response.setStartTime(activity.getStartTime().toString());
		response.setAdditionalMetrics(activity.getAdditionalMetrics());
		response.setCreatedAt(activity.getCreatedAt());
		response.setUpdatedAt(activity.getUpdatedAt());
		
		return response;
		
	}

	public List<ActivityResponse> getUserActivities(String userId)
	{
		 List<Activity> activities = activityRepository.findByUserId(userId);
		 
		 return activities.stream()
				 .map(this::mapToResponse)
				 .toList();		
	}

	public ActivityResponse getUserActivity(String activityId)
	{
		Activity activity = activityRepository.findById(activityId)
				.orElseThrow(() -> new RuntimeException("Activity not found"));
		
		return mapToResponse(activity);
	}

	public List<ActivityResponse> getAllActivity()
	{
		List<Activity> activities = activityRepository.findAll();
		
		return activities.stream()
				.map(this::mapToResponse)
				.toList();
	}

}
