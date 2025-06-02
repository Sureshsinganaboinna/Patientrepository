package com.example.demo.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class LoginApi {
	@NotNull (message = "Email is empty")
	@NotBlank (message = "Email feild is missing")
	@Pattern (regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter a valid Email")
	private String email;
	@NotNull (message = "Password is empty")
	@Size (min = 4, max=8, message = "Pssword must be 4 to 6 digits")
	private String password;

}
