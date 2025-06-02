package com.itc.restclient.service;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.SaveUser;
import com.itc.restclient.execeptions.EmailAleardyExisted;
import com.itc.restclient.execeptions.FromAccountNotFound;
import com.itc.restclient.execeptions.InvalidEmail;
import com.itc.restclient.execeptions.InvalidPassword;
import com.itc.restclient.pojo.Register;
import com.itc.restclient.pojo.TransferAmount;
import com.itc.restclient.pojo.Usesss;
import com.itc.restclient.repository.SaveRepository;

import jakarta.transaction.Transactional;



@Service
public class SaveService {

	@Autowired
	private SaveRepository saveRepository;
	
	@Autowired
	private JJwtTokenService jJwtTokenService;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public SaveUser registerUserData(Register register) {
		Optional<SaveUser> userdata = saveRepository.findByEmail(register.getEmail());

		if (userdata.isEmpty()) {

			SaveUser saveUser = new SaveUser();
			saveUser.setName(register.getName());
			saveUser.setEmail(register.getEmail());
			saveUser.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
			saveUser.setAccountnumber(register.getAccountnumber());
			saveUser.setAmount(register.getAmount());
			saveUser.setPhonenumber(register.getPhonenumber());

			SaveUser saveUser2 = saveRepository.save(saveUser);

			return saveUser2;
		} else {
			throw new EmailAleardyExisted("user is already existed with this email please login with different email");
		}

	}

	public Map<String, Object> loginRegisteredUser(Usesss usesss) {
		Optional<SaveUser> userdata = saveRepository.findByEmail(usesss.getEmail());

		if (userdata.isEmpty()) {
			throw new InvalidEmail("invalid email id, please enter valid password.");
		}
		SaveUser dbdata = userdata.get();

		boolean passwordmatch = bCryptPasswordEncoder.matches(usesss.getPassword(), dbdata.getPassword());

		if (passwordmatch == true) {
			
			
		String tokenString = jJwtTokenService.generateJwtTokenKey(dbdata);
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("token", tokenString);
			resMap.put("userinfo", userdata);
			
			return resMap;
		} else {
			throw new InvalidPassword("Entered invalid password, please valid password.");
		}
	}
	@Transactional(rollbackOn = Exception.class)
	public String transferAmount(TransferAmount transferAmount) {
		Optional<SaveUser> fromuser = saveRepository.findByAccountnumber(transferAmount.getFromaccount());

		if (fromuser.isEmpty()) {
			throw new FromAccountNotFound("we do not have an user with this account", transferAmount.getFromaccount());
		}
		
		SaveUser frromuser = fromuser.get();
		double userAmount = frromuser.getAmount();
	
		double transferAmountValue = Double.parseDouble(transferAmount.getTransferamount());
		if (userAmount < transferAmountValue || userAmount == 0) {
			throw new FromAccountNotFound("Insufficient balance. Transfer cannot proceed.",
					transferAmount.getFromaccount());
		}
		double amount = userAmount - transferAmountValue;
		frromuser.setAmount(amount);
		saveRepository.save(frromuser);

		
		Optional<SaveUser> touser = saveRepository.findByAccountnumber(transferAmount.getToaccount());
		if (touser.isEmpty()) {
			throw new FromAccountNotFound("we do not have an user with this account", transferAmount.getToaccount());
		}
	
		SaveUser ttoUser = touser.get();
		double amount1 =ttoUser.getAmount() + transferAmountValue;
		ttoUser.setAmount(amount1);
	//	saveRepository.save(ttoUser);

		return "successfully transfered amount";

	}

}
