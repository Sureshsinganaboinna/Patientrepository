package com.itc.restclient.service;

import java.util.List;

import com.itc.restclient.entities.UserEntr;



public interface UserServiceInterface {

    public UserEntr saveUser(UserEntr user);
    public UserEntr  updatePatient(UserEntr user);
    public void deleteConsultation(UserEntr user);
    public UserEntr findById(Long id);
    public List<UserEntr> findByAll();
  //  public List<Consultation> finbyid(int patientid);
    
	
	
}
