package com.itc.restclient.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupApi {
	
	
	@NotNull (message = "Email is empty")
	@NotBlank (message = "Email feild is missing")
	@Pattern (regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter a valid Email")
	private String email;
	@NotNull (message = "name is empty")
	@NotBlank (message = "name feild is missing")
	@Size (min = 4, message = "Minimum 2 charachter should be there")
	private String name;
	@NotNull (message = "password is empty")
	@Size (min = 4, max=8, message = "Pssword must be 4 to 6 digits")
	private String password;
	@NotNull (message = "mobile is empty")
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	private String mobile;

}
