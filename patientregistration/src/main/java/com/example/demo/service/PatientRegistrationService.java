package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.PatientRegistration;
import com.example.demo.pojo.Patient;

public interface PatientRegistrationService {
	
     public PatientRegistration savePatient(Patient patient);
     public PatientRegistration  updatePatient(PatientRegistration patientRegistration);
     public void deletePatient(PatientRegistration patientRegistration);
     public PatientRegistration findById(int id);
     public List<PatientRegistration> findByAll();
     

}
