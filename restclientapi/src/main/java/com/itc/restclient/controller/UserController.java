package com.itc.restclient.controller;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;

import com.itc.restclient.model.User;
import com.itc.restclient.model.UserDetails;

@RestController
public class UserController {
	
	
	@GetMapping("/home")
	public void getApiData()
	{
		RestTemplate restTemplate = new RestTemplate();
	//	 UserData restapidata =   restTemplate.getForObject("http://localhost:8080/backoffice/login", UserData.class);
		 
		
	/*	//get request to other microservices and get user specific data. 
		//below method we can only get user object details we do not get status code and headeres
	Object  userdatObject = restTemplate.getForObject("http://localhost:8080/backoffice/get/5", Object.class);
	System.out.println(userdatObject);
	//below method we can get user object with response headers and status code
	ResponseEntity<Object> userobjectwithresponse = restTemplate.getForEntity("http://localhost:8080/backoffice/get/7",
			Object.class);
	System.out.println(userobjectwithresponse.getBody());
	System.out.println(userobjectwithresponse.getStatusCode());
	System.out.println(userobjectwithresponse.getHeaders());
	*/
		
		//delete record to other microservices
    	restTemplate.delete("http://localhost:8080/backoffice/7");
    	
	   //below method is used to get all the users from other microservices
		ResponseEntity<UserDetails[]> userobjectwithresponse = restTemplate.getForEntity("http://localhost:8080/backoffice/getAllUsers",
				UserDetails[].class);
		
		UserDetails[] userDetailssDetails = userobjectwithresponse.getBody();
		
		for (UserDetails userDetails : userDetailssDetails) {
			System.out.println(userDetails);
		}
	
	
	/*//post Userdata to other microservices
	UserDetails userDetails = new UserDetails();
	userDetails.setUsername("ssss");
	userDetails.setEmail("ramudu@gmail.com");
	userDetails.setMobile("9987455786");
	userDetails.setPincode("65989");
	ResponseEntity<UserDetails>   userEntity = restTemplate.postForEntity("http://localhost:8080/backoffice/UserSave", userDetails, UserDetails.class);
	
	System.out.println(userEntity.getBody());*/
		
	
		
		
		
		
		
		
		
		
		
	
		
	/*	
		 User userData = new User();
		 userData.setEmail("sureshrajesh525@gmail.com");
		 userData.setPassword("5454");
		 
		 ResponseEntity<User> restapidata =	 restTemplate.postForEntity("http://localhost:8080/backoffice/login", userData, User.class);
		
		System.out.println(restapidata.getBody());*/
		
	}

}
