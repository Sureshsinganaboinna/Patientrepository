package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;


import com.example.demo.apiresponse.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.entity.Vechicle;
import com.example.demo.pojo.ApiCallResponseData;
import com.example.demo.pojo.ApiData;
import com.example.demo.pojo.ForgotPassword;
import com.example.demo.pojo.LoginApi;
import com.example.demo.pojo.ResetPassword;
import com.example.demo.pojo.SignupApi;
import com.example.demo.pojo.SignupData;
import com.example.demo.pojo.UpdatePassword;
import com.example.demo.pojo.UserTransaction;
import com.example.demo.pojo.VechiclesSearchApiData;
import com.example.demo.service.ApiDataService;
import com.example.demo.service.AuthService;
import com.example.demo.service.AuthService2;
import com.example.demo.service.EmailService;
import com.example.demo.service.VechicleSearchApiService;
import com.example.demo.utils.ResponseData;

import ch.qos.logback.core.model.Model;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {

	@Autowired
	public AuthService authService;
	@Autowired
	public EmailService emailService;
	@Autowired
	public VechicleSearchApiService vechicleSearchApiService;
	@Autowired
	public ApiDataService apiDataService;
	
	@Autowired
	public AuthService2 authService2;
	
     @PostMapping("/sendingAmount")
  
     public ResponseEntity<Map<String, String>> userTransactions(@RequestBody UserTransaction userTransaction) throws Exception
     {
    	
    	 String paymentResponse=  authService2.userTransactions(userTransaction);
    	 Map<String, String> dbresponseMap = new HashMap<String, String>();
   	      dbresponseMap.put("result", "success");
    	 dbresponseMap.put("usertransactiondata", paymentResponse);
    	 return ResponseEntity.status(HttpStatus.OK).body(dbresponseMap);
     }
	@PostMapping("/Vechicless")
	public ResponseEntity<?> vechiclesSearchApi(@RequestBody VechiclesSearchApiData vechiclesSearchApiData)
	{
		List<Vechicle>  vechicless = vechicleSearchApiService.vechicleSearchApiData(vechiclesSearchApiData);
//		Map<String, Object> responseMap = new HashMap<String, Object>();
//		responseMap.put("result", "success");
//		responseMap.put("Data", vechicless);
		
		ApiResponse<List<Vechicle>> response = new ApiResponse<>("success", "OK", vechicless);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/Loginwithquery")
	public  ResponseEntity<Map<String, Object>> loginWithSqlQuery(@RequestBody LoginApi loginApi, HttpServletRequest request) throws Exception
	{
		ApiCallResponseData ApiCallResponseData = apiDataService.getApiDataFromIpInfo(request.getRemoteAddr());
		Optional<User> dbresponseMap = authService.logInWithQuery(loginApi);	
		Map<String, Object> dbresponse = new HashMap<String, Object>();
		dbresponse.put("result", "success");
		dbresponse.put("LogInData", dbresponseMap);
		
		return ResponseEntity.status(HttpStatus.OK).body(dbresponse);
		//return dbresponseMap;
	}
	
	
	
	//Signup API 
	
	@PostMapping("create-account")
	public ResponseEntity<ApiResponse<User>> signupApi(@Valid @RequestBody SignupApi SignupApi, ApiCallResponseData apiCallResponseData, HttpServletRequest request) throws Exception
	{
		User users	 = authService.signupApiData(SignupApi,apiCallResponseData,request.getRemoteAddr());
		/*Map<String, Object> dbresponseMap = new  HashMap<String, Object>();
		dbresponseMap.put("result", "success");
		dbresponseMap.put("response", users);*/
		
		ApiResponse<User> response = new ApiResponse<>("success","OK", users);	
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@PostMapping("/login")
	public  ResponseEntity<Map<String, Object>> loginApi(@RequestBody LoginApi loginApi, HttpServletRequest request) throws Exception
	{
//		System.out.println(request.getContentType());
//		System.out.println(request.getMethod());
//		System.out.println(request.getRemoteAddr());
		
		ApiCallResponseData ApiCallResponseData = apiDataService.getApiDataFromIpInfo(request.getRemoteAddr());
	//	System.out.println(request.getRemoteAddr());
		Map<String, Object> dbUserData = authService.handleLoginApiLogic(loginApi);
		Map<String,Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("Login success", dbUserData);
	Map<String, Object>	dbUserData1 = authService.handleLoginApiLogic(loginApi);
		responseMap.put("ApiCallResponse", ApiCallResponseData);
		System.out.println(dbUserData1);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization",dbUserData1.get("token").toString() );
		
	//	ApiResponse<T> response = new ApiResponse<T>(null, null, null)>
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(responseMap);
		
	//	return ResponseEntity.status(HttpStatus.OK).body(dbUserData);
	}
	@GetMapping ("/send-email")
	public ResponseEntity<Map<String, String>> sendPlainTextEmail() throws MessagingException
	{
		String fromemail = "Rangulu1998@gmail.com";
		String toemail = "sureshrajesh525@gmail.com";
		String mailsubject = "Application for java developer";
		String mailbody = "This is suresh. i have been working as java";
		
	//	emailService.sendPlainTextMail(fromemail, toemail, mailsubject, mailbody);
		emailService.sendHtmlMail(fromemail, toemail, mailsubject, mailbody);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put(ResponseData.RESULT, ResponseData.SUCCESS);
		responseMap.put(ResponseData.SUCCESS, "Email sent");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		
	}
	
	@PostMapping("/ForgotPassword")
	public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPassword forgotPassword) throws Exception
	{
         //  authService.handleForgotPassword(forgotPassword);
		authService.handleForgotPassword2(forgotPassword);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "success");
		responseMap.put("result", "Reset password link has been sent your email id, you can change your password by click on link ");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	@PostMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPassword resetPassword) throws Exception
	{
		authService.handleResetPassword(resetPassword);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "success");
		responseMap.put("result", "Your password has been updated, now you can login");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	/////////////////////////////////
	@GetMapping("update/{id}")
	public Optional<User> updatePasswordUsingEmail(@PathVariable int id)
	{
		
		return authService.updateEmail(id); 
	}
	
	@GetMapping("callmantra")
	public java.util.List<User> getAllList()
	{
		return authService.getAllList();
	}
	
	/*@PostMapping("findbyemail")
	public Object postMethodName(@RequestBody FindByEmail findByEmail) {
	
		return authService.retiveDataUsingFindByEmail(findByEmail);
	}*/
	
	@PostMapping("/signup")
	public User signupForm(@RequestBody SignupData signupData)
	{
	User user =  authService.signupFormation(signupData);
		return user;
	}
	@PostMapping("password-update")
	public Map<String, String> recordDeleted(@RequestBody UpdatePassword updatePassword)
	{
	boolean isupdated = authService.updateProfile(updatePassword);
	
	Map<String, String> response = new HashMap<String, String>();
	   if(isupdated == true) {
		   response.put("result", "Success");
		   response.put("message", "Password and Email updated successfully");
	   }
	   else {
		   response.put("result", "failed");
		   response.put("message", "Password and Email not updated");
	   }
	   return response;
	}
	
	@GetMapping("user/{id}")
	public Map<String, Object> getUserData(@PathVariable int id)
	{
	  Optional<User> UserData = authService.getUserData(id);
	  
	  Map<String, Object> response = new HashMap<String, Object>();
	  if(UserData.isPresent() == true) {
		  response.put("Result", "Success");
		  response.put("Data", UserData.get());
	  }
	  else {
		response.put("Result", "Userid is not prasent");
		response.put("Data", response.get(UserData));
	}
		
	  return response;
	}
	@GetMapping("deleterecord/{id}")
	public Object getMethodName(@PathVariable int id) {
		
		boolean dbresponse = authService.deleteRecord(id);
		 
		if(dbresponse == true) {
			return authService.getAllList();
			
		}
		else {
			return "Record has been deleted";
		}
		
	}
	
	@PostMapping("singupform")
	public String singupForm(@RequestBody ApiData apiData) {
		
		String response = authService.signup(apiData);
		
		return response;
	}
	
	  @PostMapping("PageofiTC")
	    public Map<String, Object> handleLoginPage(@Valid @RequestBody ApiData apiData, BindingResult validationResult) {
		  System.out.println(validationResult.hasErrors());
		  if(validationResult.hasErrors() == true)
		  {
			  Map<String,String> errors = new HashMap<String, String>();
		       validationResult.getFieldErrors().forEach(error ->{
		    	  errors.put(error.getField(), error.getDefaultMessage());
		       });
		       int[] arrays55 = {1,2,3,4,5,6};
		       Map<String, Object> responseMap = new HashMap<String, Object>();
		       responseMap.put("result", "Failed");
		       responseMap.put("errors", errors);
		       responseMap.put("Hints", arrays55);
		       responseMap.put("message", "unable to process");
		       responseMap.put("No of attempts", 5);
		       return responseMap;
		  }
		  else {
			  
			  String response = authService.signup(apiData);
			  Map<String,Object> response1 = new HashMap<String, Object>();
			  response1.put("result", "Success");
			  response1.put("loginresult", response);
		
			
			  
			  Map<String, Object> response55 = new HashMap<String, Object>();
			 
			  response55.put("name", "Suresh");
			  response55.put("mobile", "9987456899");
			  response55.put("Email", apiData.getEmail());
			  response55.put("Password", apiData.getPassword());
			  response1.put("response", response55);
	
			  
			  return response1;
			  
			  
		}
	  
		
	    }
	
}
