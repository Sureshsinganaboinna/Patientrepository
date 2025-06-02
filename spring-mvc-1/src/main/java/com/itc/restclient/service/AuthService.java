package com.itc.restclient.service;



import java.util.HashMap;


import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.User;
import com.itc.restclient.entities.UserSignupEntityPractice;
import com.itc.restclient.pojo.ApiCallResponseData;
import com.itc.restclient.pojo.ApiData;
import com.itc.restclient.pojo.FindByEmail;
import com.itc.restclient.pojo.ForgotPassword;
import com.itc.restclient.pojo.LoginApi;
import com.itc.restclient.pojo.ResetPassword;
import com.itc.restclient.pojo.SignupApi;
import com.itc.restclient.pojo.SignupData;
import com.itc.restclient.pojo.UpdatePassword;
import com.itc.restclient.repository.UserRepository;
import com.itc.restclient.repository.UserSignupRepository;
import com.itc.restclient.utils.PasscodeGenerator2;

import jakarta.transaction.Transactional;


@Service
public class AuthService {
	
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public EmailService emailService;
	@Autowired
	public JwtService jwtService;
	@Autowired
	public UserSignupRepository userSignupRepository;
	
	public PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public Logger logger = LoggerFactory.getLogger(AuthService.class);
	
	@Transactional
	public Optional<User> logInWithQuery(LoginApi loginApi) throws Exception {

		//Optional<User> user = userRepository.dbloginwithquery(loginApi.getEmail(), loginApi.getPassword());
		Optional<User> user = userRepository.dbloginwithstoreprocedure(loginApi.getEmail(), loginApi.getPassword());
		System.out.println(user);
		if (user.isPresent() == true) {
			logger.info("User logged into backoffice email{} "+ loginApi.getEmail());
			return user;
		} else {
			logger.error("loging functionality failing");
			throw new Exception("Enter Valid details");
		}
	}
	
	
	public  User signupApiData(SignupApi signupApi, ApiCallResponseData apiCallResponseData,String ip) throws Exception
	{
		Optional<User>  dbresponse  =  userRepository.findByEmail(signupApi.getEmail());
		if(dbresponse.isEmpty())
		{
			User user = new User();
			user.setEmail(signupApi.getEmail());
			user.setMobile(signupApi.getMobile());
			user.setPassword(passwordEncoder.encode(signupApi.getPassword()));
			user.setName(signupApi.getName());
			user.setIpAddress(ip);
			User user2 = userRepository.save(user);
			System.out.println(user2);
			return user2;
		}
		else {
			throw new Exception("This email id is exists. please login");
		}
	}
	public Map<String, Object> handleLoginApiLogic(LoginApi loginApi) throws Exception
	{
		Optional<User> dbuserdata = userRepository.findByEmail(loginApi.getEmail());
		
		if(dbuserdata.isEmpty()==true)
		{
		   throw new Exception("Your email is not registered with us, please signup");
		}
		else {
			User userData = dbuserdata.get();
	//	Boolean isMatching = passwordEncoder.matches(loginApi.getPassword(),userData.getPassword());
		
			
			if(loginApi.getPassword().equals(userData.getPassword())==true) {
				
			String jwttoken =	jwtService.generateJwtToken(userData);
			Map<String, Object> userDataWithToken = new HashMap<String, Object>();
			userDataWithToken.put("token", jwttoken);
			userDataWithToken.put("userData", userData);
			
				//return userDataWithToken;
			return userDataWithToken;
			}
			else {
				throw new Exception("Inavlid password");
			}
		}
	}
	
	public void handleForgotPassword(ForgotPassword forgotPassword) throws Exception
	{
		
		Optional<User> dbData = userRepository.findByEmail(forgotPassword.getEmail());
		if(dbData.isEmpty())
		{
			throw new Exception("Entered Email is not registered with us, please check your email and try again");
		}
		String resetPasswordKey = UUID.randomUUID().toString();
		
		User dbUser = dbData.get();
		dbUser.setResetPasswordLink(resetPasswordKey);
		userRepository.save(dbUser);
		String mailbody = "Hi  "+dbUser.getName() +", <br/>"+
		                     "Please find the link: <a href='http://localhost:8080/reset-password-ui/linkid= "+ resetPasswordKey +"&"+"UserId "+dbUser.getId()+"'>click here</a><br/>"+
		                     "Regards";
				             
	//	emailService.sendHtmlMail("Rangulu1998@gmail.com", dbUser.getEmail(), "ResetPasswordLink", mailbody);
	}
	
	public void handleForgotPassword2(ForgotPassword forgotPassword) throws Exception
	{
		
		Optional<UserSignupEntityPractice> dbData = userSignupRepository.findByEmail(forgotPassword.getEmail());
		if(dbData.isEmpty())
		{
			throw new Exception("Entered Email is not registered with us, please check your email and try again");
		}
	//	String resetPasswordKey = UUID.randomUUID().toString();
//		1   String passcode4 = PasscodeGenerator.generateNumericPasscode(4); // Generate a 4-digit passcode
//	        String passcode6 = PasscodeGenerator.generateNumericPasscode(6); // Generate a 6-digit passcode
	    //2    String passcode = PasscodeGenerator2.generatePasscode(6);
		 String passcode = PasscodeGenerator2.generatePasscode(6);
	        UserSignupEntityPractice dbuserdata = dbData.get();
	        dbuserdata.setPassword(passcode);
	        
		//User dbUser = dbData.get();
	        userSignupRepository.save(dbuserdata);
		String mailbody = "Hi  "+dbuserdata.getName() +" User new password "+ dbuserdata.getPassword();
		                     
				             
	//	emailService.sendHtmlMail("Rangulu1998@gmail.com", dbuserdata.getEmail(), "Your New Password", mailbody);
	}
	
	public void handleResetPassword(ResetPassword resetPassword) throws Exception
	{
		if(resetPassword.getPassword().equals(resetPassword.getConfirmpassword()) == false)
				{
			           throw new Exception("Password and confirm password must be same");
				}
		Optional<User> dbData = userRepository.findByResetPasswordLink(resetPassword.getResetpasswordlink());
		if(dbData.isEmpty())
		{
			throw new Exception("Invalid reset password link");
		}
			User user = dbData.get();
			user.setPassword(passwordEncoder.encode(resetPassword.getConfirmpassword()));
			user.setResetPasswordLink("");
			userRepository.save(user);
			
	}

	public Optional<User> updateEmail(int id)
	{
	Optional<User> signupData=	userRepository.findById(id);
	
	
	System.out.println(signupData);
	
	return signupData;
	}
	
	public  java.util.List<User> getAllList()
	{
	     java.util.List<User> userList = userRepository.findAll();
	     
		return userList;
	}
	
	
	public Object retiveDataUsingFindByEmail(FindByEmail findByEmail)
	{
		  Optional<User>  userOptional = userRepository.findByEmail(findByEmail.getEmail());
		  if(userOptional.isPresent()){
			  return userOptional;
		  }
		  else {
			  {
				  return "User is not found";
			  }
		}
		  
		  
	}
	
	public User signupFormation(SignupData signupData)
	{
		User user = new User();
		user.setName(signupData.getUsername());
		user.setEmail(signupData.getEmail());
		user.setPassword(signupData.getPassword());
		
	      User newuserUser =   userRepository.save(user);
	      return newuserUser;
	}
	
	public boolean updateProfile(UpdatePassword updatePassword)
	{
		   Optional<User> dbresponse = userRepository.findById(updatePassword.getId());
		   
		   if(dbresponse.isPresent() == true)
		   {
			   User user =  dbresponse.get();
			   user.setEmail(updatePassword.getEmail());
			   user.setPassword(updatePassword.getPassword());
		        userRepository.save(user);
			  
			   return true;
		   }
		   else {
				return false;
		}
	}
	
		public Optional<User> getUserData(int id)
		{
			 Optional<User> user =  userRepository.findById(id);
			return user;
		}
	
		public boolean deleteRecord(int id)
		{
        Optional<User> user    =  userRepository.findById(id);
			   if(user.isPresent())
			   {
				  User user2=user.get();
				  userRepository.deleteById(user2.getId());
				  return true;
			   }
			   else {
				   {
					   return false;
				   }
			}
		 
		}
	public String signup(ApiData apiData) {
		

		String dbemail = "Singanaboina.suresh@coanetwork.com";
		String dbpassword = "4545";
		System.out.println();
		if(dbemail.equals(apiData.getEmail())  &&  dbpassword.equals(apiData.getPassword()))
				{
		return "Login successfull";
		
	}else {
		return "Invalid user credentials";
	}

	/*	if (apiData.getUsername().length() < 3) {
			return "Username is proper format" + apiData.getUsername();
		} 
		else
		{
			return "Username inValid";
		}*/
	/*	boolean Email = apiData.getEmail().matches("^[a-zA-Z0-9._%±]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");

		if (Email == true) {
			return "Email is there in proper format";
		} else if (Email == false){
			return "Invalid Email Address";
		}*/
/*		boolean mobilenumber = apiData.getMobile().matches("[0-9]{10}$");
		if (mobilenumber == true) {
			return "Mobile Number is Valid";
		} else if (mobilenumber == false){
			return "Invalid Mobile number";
		}
*/
	/*	boolean password = apiData.getPaassword().matches("^\\d{4,6}$");
		if (password == true) {
			return "Password is valid";
		} else {
			return "Invalid Password";
		}
*/
	
	}}



