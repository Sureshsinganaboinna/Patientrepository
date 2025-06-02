package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PatientRegistration;
import com.example.demo.pojo.Patient;
import com.example.demo.repository.PatientRegistrationRepository;

@Service
public class PatientService implements PatientRegistrationService {

	@Autowired
	private PatientRegistrationRepository patientRegistrationRepository;
	
	@Override
	public PatientRegistration savePatient(Patient patient) {
		
		PatientRegistration patientRegistration = new PatientRegistration();
		patientRegistration.setName(patient.getName());
		patientRegistration.setAddress(patient.getAddress());
		patientRegistration.setContactNumber(patient.getContactNumber());
		patientRegistration.setDetails(patient.getDetails());
		PatientRegistration	 Dbpatiendata = patientRegistrationRepository.save(patientRegistration);
		return Dbpatiendata;
				
	}

	@Override
	public PatientRegistration updatePatient(PatientRegistration patientRegistration) {
		
		PatientRegistration	 Dbpatiendata = patientRegistrationRepository.save(patientRegistration);
		return Dbpatiendata;
				
	}

	@Override
	public void deletePatient(PatientRegistration patientRegistration) {
		
		patientRegistrationRepository.delete(patientRegistration);
		
	}

	@Override
	public PatientRegistration findById(int id) {
		// TODO Auto-generated method stub
		return patientRegistrationRepository.findById(id).get();
	}

	@Override
	public List<PatientRegistration> findByAll() {
		// TODO Auto-generated method stub
		return patientRegistrationRepository.findAll();
	}

}
