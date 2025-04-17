package com.fitness.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;
import com.fitness.service.ActivityService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/activities")
@AllArgsConstructor
public class ActivityController
{
	private final ActivityService activityService;
	
	@PostMapping
	public ResponseEntity<ActivityResponse> trackActivity( @RequestBody ActivityRequest request)
	{
		return ResponseEntity.ok(activityService.trackActivity(request));
	}
	
	@GetMapping()
	public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId)
	{
		return ResponseEntity.ok(activityService.getUserActivities(userId));
	}
	
	@GetMapping("/{activityId}")
	public ResponseEntity<ActivityResponse> getUserActivity(@PathVariable String activityId)
	{
		return ResponseEntity.ok(activityService.getUserActivity(activityId));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ActivityResponse>> getAllActivity()
	{
		return ResponseEntity.ok(activityService.getAllActivity());
	}
	
}
