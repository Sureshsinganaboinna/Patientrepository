package com.itc.restclient.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itc.restclient.UserData;
import com.itc.restclient.entities.User;
import com.itc.restclient.execeptions.EmailNotFoundException;
import com.itc.restclient.pojo.UserTransaction;
import com.itc.restclient.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthService2 {
	
	@Autowired
	private UserRepository userRepository;
	//@Transactional(rollbackOn = Exception.class)
	public String userTransactions(UserTransaction userTransaction) 
	{
	
	      Optional<User> fromaccountuser  = userRepository.findByAccountNumber(userTransaction.getFromAccount());
           if(fromaccountuser.isEmpty())
           {      
        	   //runtimeexception
        	   throw new EmailNotFoundException("We do not have an user with this account number, please eneter valid account number ",userTransaction.getFromAccount());
           }
           
             User userData = fromaccountuser.get();
           if(userData.getAmount() < userTransaction.getAmount()) 
           {
        	   throw new RuntimeException("You do not have sufficent balance");
           }
             Double fromaccountmoneyafterdebit =  userData.getAmount() - userTransaction.getAmount();
             userData.setAmount(fromaccountmoneyafterdebit);
             userRepository.save(userData);
             Optional<User> toaccountuser = userRepository.findByAccountNumber(userTransaction.getToAccount());
             if(toaccountuser.isEmpty())
             {
            	 throw new RuntimeException("we do have an user this Toaccount, please re-check");
             }
             User touser =   toaccountuser.get();
             Double toaccount = touser.getAmount() + userTransaction.getAmount();
             touser.setAmount(toaccount);
             userRepository.save(touser);
             return "Payment has been sent successfully";
	}
	public String page(UserData userData)
	{
		String dbemail = "Singanaboina.suresh@coanetwork.com";
		String dbpassword = "4545";
		System.out.println();
		if(dbemail.equals(userData.getEmail())  &&  dbpassword.equals(userData.getPassword()))
				{
		return "Login successfull";
		
	}else {
		return "Invalid user credentials";
	}

}
}
