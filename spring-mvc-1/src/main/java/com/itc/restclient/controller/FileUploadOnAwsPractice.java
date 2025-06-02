package com.itc.restclient.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itc.restclient.entities.UserSignupEntityPractice;
import com.itc.restclient.pojo.UserLoginPagePractice;
import com.itc.restclient.pojo.UserSignupPractice;
import com.itc.restclient.service.FileUploadOnAwsServicePractice;
import com.itc.restclient.service.UserSignupPracticeService;

import jakarta.validation.Valid;

@RestController
public class FileUploadOnAwsPractice {
	
	@Autowired
	private UserSignupPracticeService userSignupPracticeService;
	
	
	@PostMapping("User/login")
	public ResponseEntity<String> userLoginPage(@Valid  @RequestBody UserLoginPagePractice userLoginPagePractice) throws Exception
	{
		  String loginrespose = userSignupPracticeService.userLoginPagePractice(userLoginPagePractice);
		return ResponseEntity.status(HttpStatus.OK).body(loginrespose);
	}
	
	@PostMapping("Callmantra/Signup")
	public ResponseEntity<Map<String, Object>> userSignupFormPractice(@Valid @RequestBody UserSignupPractice userSignupPractice) throws Exception
	{
		
		UserSignupEntityPractice userSignupEntityPractice = userSignupPracticeService.userSignupForm(userSignupPractice);
				
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("dbresponse", userSignupEntityPractice);
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	@Autowired
	public FileUploadOnAwsServicePractice fileUploadOnAwsServicePractice;
	
	@PostMapping("upload/Allfiles")
	public ResponseEntity<?> uploadFiles(@RequestParam("pdf_file") MultipartFile inputFile) throws Exception
	{
		
		fileUploadOnAwsServicePractice.uploadPdfFile(inputFile);
		return ResponseEntity.status(HttpStatus.OK).body(inputFile);
	
	}

}
