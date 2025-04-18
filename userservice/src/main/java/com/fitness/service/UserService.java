package com.fitness.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.model.User;
import com.fitness.repository.UserRepository;

@Service
public class UserService
{
	// This class will contain the business logic for user registration and authentication
	// It will interact with the UserRepository to perform CRUD operations on the User entity
	// It will also handle password encryption and token generation for authentication
	// The service will be annotated with @Service to indicate that it is a service layer component
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}



	public UserResponse registerUser(RegisterRequest registerRequest)
	{
		// Check if the user already exists
		if (userRepository.existsByEmail(registerRequest.getEmail()))
		{
			throw new RuntimeException("User already exists");
		}
		
		// Create a new User entity
		User user = new User();
		
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		
		// Save the user to the database
		User savedUser = userRepository.save(user);
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setId(savedUser.getId());
		userResponse.setPassword(savedUser.getPassword());
		userResponse.setEmail(savedUser.getEmail());
		userResponse.setFirstName(savedUser.getFirstName());
		userResponse.setLastName(savedUser.getLastName());
		userResponse.setCreatedAt(savedUser.getCreatedAt());
		userResponse.setUpdatedAt(savedUser.getUpdatedAt());
		
		return userResponse;
	}
	
	public UserResponse getUserById(String id)
	{
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setId(user.getId());
		userResponse.setPassword(user.getPassword());
		userResponse.setEmail(user.getEmail());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setCreatedAt(user.getCreatedAt());
		userResponse.setUpdatedAt(user.getUpdatedAt());
		
		return userResponse;
	}
	
	public void deleteUserById(String id)
	{
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		
		userRepository.delete(user);
	}
	
	public UserResponse updateUser(String id, RegisterRequest registerRequest)
	{
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		
		User updatedUser = userRepository.save(user);
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setId(updatedUser.getId());
		userResponse.setPassword(updatedUser.getPassword());
		userResponse.setEmail(updatedUser.getEmail());
		userResponse.setFirstName(updatedUser.getFirstName());
		userResponse.setLastName(updatedUser.getLastName());
		userResponse.setCreatedAt(updatedUser.getCreatedAt());
		userResponse.setUpdatedAt(updatedUser.getUpdatedAt());
		
		return userResponse;
	}
	
	public UserResponse getUserByEmail(String email)
	{
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setId(user.getId());
		userResponse.setPassword(user.getPassword());
		userResponse.setEmail(user.getEmail());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setCreatedAt(user.getCreatedAt());
		userResponse.setUpdatedAt(user.getUpdatedAt());
		
		return userResponse;
	}
	
	public List<User> getAllUsers()
	{
		Iterable<User> users = userRepository.findAll();
		
		return StreamSupport.stream(users.spliterator(), false)
				.collect(Collectors.toList());
		
		
	}



	public Boolean validateUser(String userId) 
	{
		
		return userRepository.existsById(userId);
	}
}
