package com.itc.restclient.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Register {
	
	@NotBlank
	@NotNull(message = "name must be entered.")
	private String name;
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "enter valid email address")
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 4, max = 6, message = "password must be 4 to 6 digits.")
	private String password;
	@Size(min = 10, message = "phone number must be 10 digits")
	private String phonenumber;
	private String accountnumber;
	private double amount;

}
