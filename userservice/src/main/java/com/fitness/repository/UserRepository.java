package com.fitness.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.fitness.model.User;

public interface UserRepository extends CrudRepository<User, String>
{
	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
}
