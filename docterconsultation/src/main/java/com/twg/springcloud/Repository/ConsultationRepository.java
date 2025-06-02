package com.twg.springcloud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.springcloud.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

	
	  List<Consultation> findByPatientid(int patientid);
	
}
