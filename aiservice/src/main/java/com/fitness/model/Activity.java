package com.fitness.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class Activity
{
	private String id;
	private String userId;
	private String userName;
	private ActivityType activityType;
	private Integer duration;
	private Integer caloriesBurned;
	private LocalDateTime startTime;
	private Map<String, Object> additionalMetrics;
	private LocalDateTime createdAt;	
	private LocalDateTime updatedAt;

}
