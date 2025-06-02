package com.itc.restclient.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Usss {
	
	@NotEmpty(message = "email should not be empty")
	@NotNull(message = "email must be entered")
	@Pattern(regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "enter a valid email")
	private String email;
	@NotEmpty(message = "passcode should not be empty")
	@Size(min = 4, max = 6, message = "passcode must be entered between 4 to 6 digits")
	private String passcode;

	
}
