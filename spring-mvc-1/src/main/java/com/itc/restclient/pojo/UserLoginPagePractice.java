package com.itc.restclient.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginPagePractice {

	@NotNull(message = "email is missing")
	@NotEmpty(message = "email is empty")
	@Pattern (regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter valid email address")
	private String email;
	
	@NotNull(message = "password is missing")
	@NotEmpty(message = "password is empty")
	@Size(min = 4,max = 6, message = "password must be 4 to 6 digits")
	private String password;
	
	
}
