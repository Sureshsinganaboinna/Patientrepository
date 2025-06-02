package com.twg.springcloud.service;

import java.util.List;


import com.twg.springcloud.entities.Consultation;

public interface ConsultationService {

    public Consultation saveConsultation(Consultation consultation);
    public Consultation  updatePatient(Consultation consultation1);
    public void deleteConsultation(Consultation consultation);
    public Consultation findById(int id);
    public List<Consultation> findByAll();
    public List<Consultation> finbyid(int patientid);
    
	
	
	
}
