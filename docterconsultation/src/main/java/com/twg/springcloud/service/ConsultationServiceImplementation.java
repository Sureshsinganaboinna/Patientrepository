package com.twg.springcloud.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springcloud.Repository.ConsultationRepository;
import com.twg.springcloud.entities.Consultation;

@Service
public class ConsultationServiceImplementation implements ConsultationService {

	@Autowired
	public ConsultationRepository consultationRepository;
	
	
	@Override
	public Consultation saveConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		return consultationRepository.save(consultation);
	}

	@Override
	public Consultation updatePatient(Consultation consultation1) {
		// TODO Auto-generated method stub
		return consultationRepository.save(consultation1);
	}

	@Override
	public void deleteConsultation(Consultation consultation) {
		consultationRepository.delete(consultation);
	}

	@Override
	public Consultation findById(int id) {
		return consultationRepository.findById(id).get();
	}

	@Override
	public List<Consultation> findByAll() {
	
		return consultationRepository.findAll();
	}

	@Override
	public List<Consultation> finbyid(int patientid) {
	
	List<Consultation> patientList	=  consultationRepository.findByPatientid(patientid);
		return patientList;
	}

}
