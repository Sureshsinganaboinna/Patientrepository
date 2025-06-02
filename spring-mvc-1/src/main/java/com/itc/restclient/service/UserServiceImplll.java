package com.itc.restclient.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.UserEntr;
import com.itc.restclient.repository.UserEntRepository;



@Service
public class UserServiceImplll implements UserServiceInterface {

	
	@Autowired
	private UserEntRepository userEntRepository;
	
	@Override
	public UserEntr saveUser(UserEntr user) {
		// TODO Auto-generated method stub
		return userEntRepository.save(user);
	}

	@Override
	public UserEntr updatePatient(UserEntr user) {
		// TODO Auto-generated method stub
		return userEntRepository.save(user);
	}

	@Override
	public void deleteConsultation(UserEntr user) {
		userEntRepository.delete(user);

	}

	@Override
	public UserEntr findById(Long id) {
		// TODO Auto-generated method stub
		return userEntRepository.findById(id).get();
	}

	@Override
	public List<UserEntr> findByAll() {
		// TODO Auto-generated method stub
		return userEntRepository.findAll();
	}

}
