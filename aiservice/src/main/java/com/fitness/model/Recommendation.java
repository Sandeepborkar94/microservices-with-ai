package com.fitness.model;

import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "recommendations")
@Builder
public class Recommendation 
{
	@Id
	private String id;
	private String userId;
	private String activityId;
	private String activityType;
	private String recommendation;
	private List<String> improvements;
	private List<String> suggestions;
	private List<String> safetyTips;
	private String reason;
	
	@CreatedDate
	private String createdAt;
	private String updatedAt;

}
