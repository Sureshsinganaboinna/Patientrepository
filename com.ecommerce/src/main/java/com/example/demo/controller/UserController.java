package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveuser")
	public User saveUsersDetails(@RequestBody User user)
	{
		User userss = userService.savesUsersInformation(user);
		
		return userss;
	}
	
	
	
	@GetMapping("/getUserByEmail")
	public Optional<User> saveUsersDetails(@RequestParam String email)
	{
		Optional<User> userss = userService.getUserInfoUsingEmail(email);	
		return userss;
	}
	
	@GetMapping("/userInfo/{userId}")
	public List<User> getUsers(@PathVariable Long userId)
	{
	List<User>	userss  = userService.getUserDetList(userId);
	
	return userss;
	}
	
	
	

}
