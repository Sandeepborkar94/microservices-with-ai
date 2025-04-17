package com.fitness.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "activities")
@Builder
@AllArgsConstructor
public class Activity
{
	private String activityId;
	private String userName;
	private ActivityType activityType;
	private Integer duration;
	private Integer caloriesBurned;
	private LocalDateTime startTime;
	
	@Field("metrics")
	private Map<String, Object> additionalMetrics;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;

}
