package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResetPassword {
	
	@NotNull( message = "reset password link is empty")
	private String resetpasswordlink;
	@NotNull (message = "Password is empty")
	@Size (min = 4, max=8, message = "Password must be 4 to 6 digits")
	private String password;
	@NotNull (message = "Password is empty")
	@Size (min = 4, max=8, message = "Password must be 4 to 6 digits")
	private String confirmpassword;

}
