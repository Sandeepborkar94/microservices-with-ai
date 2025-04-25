package com.fitness.repository;

import org.springframework.data.repository.CrudRepository;

import com.fitness.model.User;

public interface UserRepository extends CrudRepository<User, String>
{
	boolean existsByEmail(String email);

	User findByEmail(String email);

	Boolean existsByKeycloakId(String userId);
}
