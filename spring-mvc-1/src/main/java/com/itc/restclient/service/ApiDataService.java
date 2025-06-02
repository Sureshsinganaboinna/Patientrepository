package com.itc.restclient.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itc.restclient.entities.ApiResponseData;
import com.itc.restclient.pojo.ApiCallResponseData;
import com.itc.restclient.repository.ApiResponseRepository;




@Service
public class ApiDataService {
	
	@Value("${Ipinfo.token}")
	private String token;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApiResponseRepository  apiResponseRepository;
	
	
	public  ApiCallResponseData getApiDataFromIpInfo (String Ipaddress)
	{
		 Ipaddress = "183.82.96.132";
		System.out.println(Ipaddress);
		//ipinfo.io/8.8.8.8?token=a19b241abf71f4
		//URL : https://
		//Domain : ipinfo.io
		// IP address : 8.8.8.8
		//Token : ?token=a19b241abf71f4
		
		//RestTemplate restTemplate = new RestTemplate();
		// URL -->Method type ---> Input Data ---> Response
		//Input Data Type
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//input Data
		String inputData = "";
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(inputData, headers);
		
		String Ipinfourl = "https://ipinfo.io/"+Ipaddress+"?"+ token;
		System.out.println(Ipinfourl);
		
		ResponseEntity<ApiCallResponseData> ApiResponse  = restTemplate.exchange(Ipinfourl, HttpMethod.GET, requestEntity, ApiCallResponseData.class);
		
		System.out.println(ApiResponse.getBody());
		
		ApiResponseData apiResponseData = new ApiResponseData();
		apiResponseData.setIp(ApiResponse.getBody().getIp());
		apiResponseData.setCity(ApiResponse.getBody().getCity());
		apiResponseData.setCountry(ApiResponse.getBody().getCountry());
		apiResponseData.setLoc(ApiResponse.getBody().getLoc());
		apiResponseData.setOrg(ApiResponse.getBody().getOrg());
		apiResponseData.setPostal(ApiResponse.getBody().getRegion());
		apiResponseData.setReadme(ApiResponse.getBody().getReadme());
		apiResponseData.setTimezone(ApiResponse.getBody().getTimezone());
		apiResponseData.setRegion(ApiResponse.getBody().getRegion());
		
		apiResponseRepository.save(apiResponseData);
		
		return ApiResponse.getBody();
		
	}
	

}
