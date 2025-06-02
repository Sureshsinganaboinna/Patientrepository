package com.itc.restclient.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.UserSignupEntityPractice;
import com.itc.restclient.pojo.UserLoginPagePractice;
import com.itc.restclient.pojo.UserSignupPractice;
import com.itc.restclient.repository.UserSignupRepository;



@Service
public class UserSignupPracticeService {
	
	@Autowired
	private UserSignupRepository userSignupRepository;
	
	
    public String userLoginPagePractice(UserLoginPagePractice userLoginPagePractice) throws Exception
    {
            Optional<UserSignupEntityPractice> dbuserResponse = userSignupRepository.findByEmail(userLoginPagePractice.getEmail());
            if(dbuserResponse.isEmpty())
            {
            	throw new Exception("Entered email is not registered with us, please sign in");
            }
          UserSignupEntityPractice dbUserSignupEntityPractice =   dbuserResponse.get();
           if(dbUserSignupEntityPractice.getPassword().equals(userLoginPagePractice.getPassword()))
          
            return "Successfully logged into itc backoffice";
           else {
			throw new Exception("Enter valid password");
		}
      
    }
	
	
	

	public UserSignupEntityPractice userSignupForm(UserSignupPractice userSignupPractice) throws Exception
	{
		 Optional<UserSignupEntityPractice> dbresponse  =  userSignupRepository.findByEmail(userSignupPractice.getEmail());
		 if(dbresponse.isEmpty())
		 {
			 UserSignupEntityPractice userdataEntityPractice = new UserSignupEntityPractice();
			 
			 userdataEntityPractice.setEmail(userSignupPractice.getEmail());
			 userdataEntityPractice.setMobile(userSignupPractice.getMobile());
			 userdataEntityPractice.setName(userSignupPractice.getName());
			 userdataEntityPractice.setPassword(userSignupPractice.getPassword());
			 userdataEntityPractice.setPrice(userSignupPractice.getPrice());
			 userdataEntityPractice.setZipcode(userSignupPractice.getZipcode());
			 UserSignupEntityPractice	  dbuserdata = userSignupRepository.save(userdataEntityPractice);
			 
			 return dbuserdata;
			 
		 }
		 else {
			throw new Exception("This email is already exists, please sign in");
		}
		 
	}

}
