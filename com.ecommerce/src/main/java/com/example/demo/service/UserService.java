package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User savesUsersInformation(User user)
	{
		 User dbuser = userRepository.save(user);
		 return dbuser;
	}
	
	
	public Optional<User> getUserInfoUsingEmail(String email)
	{
		 Optional<User> dbuser = userRepository.findByEmail(email);
		 return dbuser;
	}

	public List<User> getUserDetList(Long userId)
	{
		
	   List<User> userDetailsList =	userRepository.getUserDetails(userId);
		
		return userDetailsList;
		
	}
		
	
	
}
