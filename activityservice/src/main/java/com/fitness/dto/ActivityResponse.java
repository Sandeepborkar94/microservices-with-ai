package com.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.model.ActivityType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse
{
	private String id;
	private String userId;
	private ActivityType activityType;
	private Integer duration;
	private Integer caloriesBurned;
	private String startTime;
	private Map<String, Object> additionalMetrics;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	
}
