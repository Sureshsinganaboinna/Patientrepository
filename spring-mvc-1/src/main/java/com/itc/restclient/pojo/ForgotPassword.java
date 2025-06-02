package com.itc.restclient.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ForgotPassword {
	
	@NotNull (message = "Email is empty")
	@NotBlank (message = "Email feild is missing")
	@Pattern (regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter a valid Email")
	private String email;

}
