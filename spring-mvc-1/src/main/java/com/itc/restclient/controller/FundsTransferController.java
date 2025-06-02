package com.itc.restclient.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.SaveUser;
import com.itc.restclient.execeptions.AuthorizationTokenException;
import com.itc.restclient.pojo.Register;
import com.itc.restclient.pojo.TransferAmount;
import com.itc.restclient.pojo.Usesss;
import com.itc.restclient.service.JJwtTokenService;
import com.itc.restclient.service.SaveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funds")
public class FundsTransferController {
	
	
	@Autowired
	private SaveService saveService;
	
	@Autowired
	private JJwtTokenService jJwtTokenService;

	
	@PostMapping("/register")
	public ResponseEntity<SaveUser> saveUserDetails(@Valid @RequestBody Register Register)
	{
		SaveUser saveUser	= saveService.registerUserData(Register);
		HashMap<String, Object> resHashMap = new HashMap<String, Object>();
		resHashMap.put("result", "success");
		resHashMap.put("response", saveUser);

		return ResponseEntity.status(HttpStatus.OK).body(saveUser);
	}
	
	@PostMapping("/loginRegisterUser")
	public ResponseEntity<HashMap<String, Object>> loginUser(@RequestBody Usesss usesss)
	{
	Map<String, Object> loggedreString =	saveService.loginRegisteredUser(usesss);
	HashMap<String, Object> resHashMap = new HashMap<String, Object>();
	resHashMap.put("result", "success");
	resHashMap.put("response", loggedreString);

	return ResponseEntity.status(HttpStatus.OK).body(resHashMap);
	}
	
	@PostMapping("/transferamount")
	public ResponseEntity<HashMap<String, Object>> transferAccount( @RequestHeader("Authorization") String Authonticationheader  ,  @RequestBody TransferAmount transferAmount )
	{
		if(Authonticationheader == null ||! Authonticationheader.startsWith("Bearer"))
		{
			throw new AuthorizationTokenException("Authorization header is missing or invalid");
		}
		
		String extracttoken = Authonticationheader.substring(7);
		
String decodetokeninfo	=	jJwtTokenService.decodeJwtToken(extracttoken);
		

		String transferamount =	saveService.transferAmount(transferAmount);
		
		HashMap<String, Object> resHashMap = new HashMap<String, Object>();
		resHashMap.put("result", "success");
		resHashMap.put("response", transferamount);
		resHashMap.put("token", decodetokeninfo);
		return ResponseEntity.status(HttpStatus.OK).body(resHashMap);
	}

}
