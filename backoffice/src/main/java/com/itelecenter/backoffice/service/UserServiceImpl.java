package com.itelecenter.backoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itelecenter.backoffice.entity.User;
import com.itelecenter.backoffice.repository.UserEntRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {

	
	@Autowired
	private UserEntRepository userEntRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userEntRepository.save(user);
	}

	@Override
	public User updatePatient(User user) {
		// TODO Auto-generated method stub
		return userEntRepository.save(user);
	}

	@Override
	public void deleteConsultation(User user) {
		userEntRepository.delete(user);

	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userEntRepository.findById(id).get();
	}

	@Override
	public List<User> findByAll() {
		// TODO Auto-generated method stub
		return userEntRepository.findAll();
	}

}
