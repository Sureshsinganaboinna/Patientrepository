package com.itc.restclient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Entra;
import com.itc.restclient.entities.Usesss;
import com.itc.restclient.pojo.Ent;
import com.itc.restclient.pojo.Usss;
import com.itc.restclient.repository.EntraaaRepository;
import com.itc.restclient.repository.UsesssRepository;

@Service
public class UsessService {
	
	@Autowired
	private UsesssRepository usesssRepository;
	@Autowired
	private EntraaaRepository entraaaRepository;
	
	public Usesss saveUserRegisterInfo(Usss usss)
	{
		Usesss usesss = new Usesss();
		usesss.setEmail(usss.getEmail());
		usesss.setPasscode(usss.getPasscode());
		return usesssRepository.save(usesss);
		
	}
	public Optional<Usesss> userLogIn(Usss usss) throws Exception
	{
		Optional<Usesss> usesss = usesssRepository.findByEmail(usss.getEmail());
		
   	
		if(usesss.isPresent()) {
			 Usesss  sUsesss =	usesss.get();
			 if(sUsesss.getPasscode().equals(usss.getPasscode()))
		      {
		  		return usesss;
		      }
			
			 throw new Exception("please enter valid password");
		}
		 throw new Exception( "user is not registered with this email : "+usss.getEmail());
	
		
	}
	
	public void saveUserEntry(Ent ent)
	{
		Entra entraa = new Entra();
		entraa.setDescription(ent.getDescription());
		entraa.setEntrydate(ent.getEntrydate());
		entraa.setUsid(entraa.getUsid());
    	entraaaRepository.save(entraa);
	}
	

}
