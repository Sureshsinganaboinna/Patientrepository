package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptions {
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<Map<String, Object>> handleApiDataValidationsException(MethodArgumentNotValidException ex)
	{
		Map<String, String> response = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach( error ->{
			response.put(error.getField(), error.getDefaultMessage());
		});
		Map<String, Object> errorresponseMap = new HashMap<String,Object>();
		errorresponseMap.put("result", "failed");
		errorresponseMap.put("error", response);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorresponseMap);
	}*/
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleUserSignupValidationPractice(MethodArgumentNotValidException ex)
	{
		Map<String, String> reponseMap = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			reponseMap.put(error.getField(), error.getDefaultMessage());
		}	);
		
		Map<String, Object> validationResponseMap = new HashMap<String, Object>();
		validationResponseMap.put("result", "failed");
		validationResponseMap.put("error", reponseMap);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResponseMap);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleExceptionErrors(Exception ex)
	{
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "failed");
		responseMap.put("error", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
	}
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<?> handleEmailNotFoundException(EmailNotFoundException ex)
	{
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("result", "failed");
		resMap.put("error", ex.getMessage() + ex.accountnumber);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resMap);
		
	}
	
	/*
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<Map<String, String>> handleGenericexception(Exception ex)
	{
		Map<String, String> response = new HashMap<String, String>();
		response.put("result", "failed");
		response.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}*/
	@ExceptionHandler(HttpClientErrorException.class)
	public  ResponseEntity<Map<String, String>> handleApiCallException(HttpClientErrorException ex)
	{
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "failed");
		responseMap.put("error", ex.getMessage());
		return ResponseEntity.status(ex.getStatusCode()).body(responseMap);
	}
}
