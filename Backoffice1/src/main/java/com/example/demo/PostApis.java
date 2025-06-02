package com.example.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApis {
	
	
	//Folder Structure Class
		@PostMapping("v1/login")
		public String loginItcbackoffice(@RequestBody UserData1 userData1) {
			String dbemail = "Singanaboina.suresh@coanetwork.com";
			String dbpassword = "9987456896";
			if(dbemail.equals(userData1.getEmail()) && dbpassword.equals(userData1.getPassword()))
					{
				return "login successfully";
					}
			else if(dbemail.equals(userData1.getEmail()) && !dbpassword.equals(userData1.getPassword()) )
			{
				return "invalid password";
			}
			else if(!dbemail.equals(userData1.getEmail()) && dbpassword.equals(userData1.getPassword()))
			{
				return "Invalid Email";
			}
			else {
				return "invalid login credentials";
			}
			
			//return "login successfully   " + userData1.toString();
			//return "login successfully   " + userData1.getEmail()+userData1.getPassword();
		}
		
	
	
	
	
	
	
	
	
	
	/////////////////////////////////
	
	@PostMapping("qa.coasecure.com")
	public String loginItcbackOffice(@RequestParam String email, @RequestParam String password)
	{
		return "Login successfull  "+ email +"  "+ password;
	}
	@PostMapping ("reset-password")
	public String resetPassword(@RequestParam String emailid)
	{
		return "Reset password link has been sent your email id, please check it"+ "  " + emailid;
	}
	@PostMapping("auth/facebook.com")
	public String signup(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String mobile)
	{
		return "successfully signed up   "+ 
	    " Name:- " + name + "Emailid :- " + email + "Password:- " + password + "Mobile Number:- " + mobile;
	}
	@PostMapping("facebook.com")
	public String signup2(@RequestBody UserData userdata)
	{
		return "successfully signed up   "+ 
	    " Name:- " + userdata.getName() + "Emailid :- " + userdata.getEmail() + "Password:- " + userdata.getPassword() + "Mobile Number:- " + userdata.getMobile();
	}
	@PostMapping("livefacebook.com") //JSON format data @RequestBody
	public String signup3(@RequestBody UserData userdata)
	{
		return "successfully signed up   "+  userdata.toString();
	}
    @PostMapping("facebook") //formdata @modelAttribute
	public String signup4(@ModelAttribute UserData userdata)
	{
		return "Signed up" + userdata.toString();
	}
	
	
}
