package com.itc.restclient.execeptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	
//	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, Object>> handlUserValidationsww(MethodArgumentNotValidException ex)
//	{
//		Map<String, String> resMap = new HashMap<String, String>();
//		ex.getBindingResult().getFieldErrors().forEach( errr->{
//		resMap.put(errr.getField(), errr.getDefaultMessage());
//	});
//		Map<String, Object> resMap2 = new HashMap<String, Object>();
//		resMap2.put("result", "failed");
//		resMap2.put("error", resMap);
//		
//	
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resMap2);
//	}
//	
//	
	
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleUserSignupValidationPractice(MethodArgumentNotValidException ex) {
		Map<String, String> reponseMap = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			reponseMap.put(error.getField(), error.getDefaultMessage());
		});
		Map<String, Object> validationResponseMap = new HashMap<String, Object>();
		validationResponseMap.put("result", "failed");
		validationResponseMap.put("error", reponseMap);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResponseMap);
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String, Object>> methodArgumentException(MethodArgumentNotValidException ex) {
		HashMap<String, String> resHashMap = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> resHashMap.put(error.getField(), error.getDefaultMessage()));
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "Failed");
		resMap.put("error", resHashMap);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resMap);
	}

	@ExceptionHandler(EmailAleardyExisted.class)
	public ResponseEntity<HashMap<String, String>> userEmailAleardyExtisted(EmailAleardyExisted ex)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("result", "failed");
		hashMap.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleExceptionErrors(Exception ex) {
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "failed");
		responseMap.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<?> handleEmailNotFoundException(EmailNotFoundException ex) {
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("result", "failed");
		resMap.put("error", ex.getMessage() + ex.accountnumber);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resMap);
	}

	@ExceptionHandler(EmailnotFoundEx.class)
	public ResponseEntity<Map<String, String>> handleEmail(EmailnotFoundEx ex) {
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("result", "failed");
		resMap.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resMap);
	}

	@ExceptionHandler(FromAccountNotFound.class)
	public ResponseEntity<Map<String, String>> handleFromaccount(FromAccountNotFound ex) {
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("result", "failed");
		resMap.put("error", ex.getMessage() + ex.getFromaccount());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resMap);
	}

	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<Object> invalidEmailException(InvalidEmail ex) {
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("result", "failed");
		resMap.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resMap);

	}
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<Map<String, String>> invalidPasswordException(InvalidPassword ex)
	{
		Map<String, String> ressMap = new HashMap<String, String>();
		ressMap.put("result", "failed");
		ressMap.put("error", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ressMap);
	}
	
	@ExceptionHandler(TokenExperiy.class)
	public ResponseEntity<Map<String, String>> invalidPasswordExceptio(TokenExperiy ex)
	{
		Map<String, String> ressMap = new HashMap<String, String>();
		ressMap.put("result", "failed");
		ressMap.put("error", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ressMap);
	}
	
	
	
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<Map<String, String>>
	 * handleGenericexception(Exception ex) { Map<String, String> response = new
	 * HashMap<String, String>(); response.put("result", "failed");
	 * response.put("error", ex.getMessage()); return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); }
	 */
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Map<String, String>> handleApiCallException(HttpClientErrorException ex) {
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "failed");
		responseMap.put("error", ex.getMessage());
		return ResponseEntity.status(ex.getStatusCode()).body(responseMap);
	}
}
