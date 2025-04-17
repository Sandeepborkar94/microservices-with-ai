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
public class ActivityRequest 
{
	private String id;
	private String userid;
	private ActivityType activityType;
	private Integer duration;
	private Integer caloriesBurned;
	private LocalDateTime startTime;
	private Map<String, Object> additionalMetrics;
}
