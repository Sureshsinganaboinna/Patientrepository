package com.twg.springcloud.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class Patient {
	private String name;
	private String address;
	@Size(min = 10, max = 10, message = "phone number must be 10 digits")
	private String contactNumber;
	private String details;
	
	
}
