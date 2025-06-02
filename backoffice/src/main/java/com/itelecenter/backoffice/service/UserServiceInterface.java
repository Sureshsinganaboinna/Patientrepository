package com.itelecenter.backoffice.service;

import java.util.List;

import com.itelecenter.backoffice.entity.User;


public interface UserServiceInterface {

    public User saveUser(User user);
    public User  updatePatient(User user);
    public void deleteConsultation(User user);
    public User findById(Long id);
    public List<User> findByAll();
  //  public List<Consultation> finbyid(int patientid);
    
	
	
}
