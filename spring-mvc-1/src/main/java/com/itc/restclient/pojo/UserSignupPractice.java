package com.itc.restclient.pojo;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UserSignupPractice {
	
	@NotNull(message = "name is missing")
	@NotEmpty(message = "name is empty")
	private String name;
	
	@NotNull(message = "email is missing")
	@NotEmpty(message = "email is empty")
	@Pattern (regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter valid email address")
	private String email;
	
	@NotNull(message = "password is missing")
	@NotEmpty(message = "password is empty")
	@Size(min = 4,max = 6, message = "password must be 4 to 6 digits")
	private String password;
	
	@NotNull(message = "mobile is missing")
	@NotEmpty(message = "mobile is empty")
	@Size(max = 10, message = "mobile must be 10 digits")
	private String mobile;
	@NotNull(message = "zipcode is missing")
	@NotEmpty(message = "zipcode is empty")
	@Size(min = 5, max = 5, message = "zip code must be 5 digits")
	private String zipcode;
	private BigDecimal price;
	
}
