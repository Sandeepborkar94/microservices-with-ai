package com.fitness.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fitness.model.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String>
{
	List<Activity> findByUserId(String userId);
}
