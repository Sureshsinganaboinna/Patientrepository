package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class Authentication {
	
	
	@GetMapping("create account")
	public String signup() {
		System.out.println("Signup API");
		return "Succesfully created an account";
		
	}
	@GetMapping("resetPassword")
	public String resetPassword()
	{
		System.out.println("reset Password API");
		return "Successfully resetPassword";
	}
	
	

}
