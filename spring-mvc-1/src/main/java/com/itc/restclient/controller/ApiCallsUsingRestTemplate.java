package com.itc.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itc.restclient.pojo.UseData;
import com.itc.restclient.service.EmpService;

import io.jsonwebtoken.security.Request;


@RestController
public class ApiCallsUsingRestTemplate {	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/getData")
	public void ApiCallsFromItelecener()
	{
		//UseData  userEntity = restTemplate.getForObject("http://localhost:8080/itelecenter/get/2", UseData.class);
		// System.out.println(userEntity);
		 
//		 ResponseEntity<UseData>  userEntity = 	 restTemplate.getForEntity("http://localhost:8080/itelecenter/get/2", UseData.class);
//		 
//		 System.out.println(userEntity);
//		 System.out.println(userEntity.getHeaders());
		 UseData useData = new UseData();
		 useData.setId((long) 6);
		 useData.setEmail("RameshVarma@gmail.com");
		 useData.setMobile("998744568");
		 useData.setPincode("23232");
		 useData.setUserName("Varma");
		// restTemplate.postForEntity("http://localhost:8080/itelecenter/UserSave", useData, UseData.class);
		// restTemplate.postForEntity("http://localhost:8080/itelecenter/update", useData, UseData.class);
		// restTemplate.getForObject("http://localhost:8080/itelecenter/2", UseData.class);
		 
		 ResponseEntity<UseData[]>  userEntity = restTemplate.getForEntity("http://localhost:8080/itelecenter/getAllUsers", UseData[].class);
		 
		 UseData[] useDatas = userEntity.getBody();
		 for (UseData user : useDatas) {
             System.out.println(user); // Assuming UseData has a proper toString() method
         }
	//	 System.out.println(useDatas);
		// System.out.println(userEntity.getHeaders());
		 
	}
	

	
	
}
	
	
	
	
