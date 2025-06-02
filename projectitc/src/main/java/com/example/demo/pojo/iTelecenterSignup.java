package com.example.demo.pojo;

import java.time.LocalDate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class iTelecenterSignup {
	
	@NotNull(message = "first name must be there")
	private String firstname;
	@NotNull(message = "last name must be there")
	private String lastname;
	@NotNull(message = "email should not be null")
	@Pattern(regexp = "^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$", message = "Enter valid email address")
	private String email;
	@Size(min =10,max = 10, message = "phone number must be 10 digits")
	private String phonenumber;
	@NotNull(message = "companyname should not be null")
    private String companyname;
	
    private String address;
    @Size(min = 5, max = 5, message = "zipcode must be 5 digits")
    private String zipcode;
    
    @AssertTrue(message = "Fax must be true")
    private boolean fax;
    @NotNull(message = "Date must be entered")
    private LocalDate presentDate;

}
