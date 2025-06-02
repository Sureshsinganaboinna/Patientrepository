package com.example.demo.pojo;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApiData {
	
	@NotNull(message="Email is missing")
	@NotBlank(message="Email is empty")
	@Pattern(regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter a valid Email")
	private String email;

	@NotNull(message = "Password is missing")
	@NotBlank(message = "Password is empty")
	@Size(min = 4,max = 6, message = "Password must be at least 4 characters long")
	private String password;


}
