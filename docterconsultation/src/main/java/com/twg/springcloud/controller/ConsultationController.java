package com.twg.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twg.springcloud.dto.Patient;
import com.twg.springcloud.entities.Consultation;
import com.twg.springcloud.restclient.PatientRegRestclient;
import com.twg.springcloud.service.ConsultationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/consultationss")
public class ConsultationController {
	
	@Autowired
	public ConsultationService consultationService;
	
	@Autowired
	public PatientRegRestclient patientRegRestclient;
	
	@GetMapping("/{id}")
	public Consultation getMethodName(@PathVariable int id) {
		
		return consultationService.findById(id);
	}
	
	@GetMapping("/")
	public List<Consultation> getAllConultations()
	{
		return consultationService.findByAll();
	}
	@PostMapping("/Save")
	public Consultation postMethodName(@RequestBody Consultation consultation) {
		System.out.println(consultation.getDoctername());
	Patient patient = patientRegRestclient.getPatientDetails(consultation.getPatientid());
	
	System.out.println("Patient Details: \n" + patient.toString());
		return consultationService.saveConsultation(consultation);
	}
	@DeleteMapping("/{id}")
	public void deleteConsultationData(@PathVariable int id)
	{
	Consultation consultation	=  consultationService.findById(id);
		consultationService.deleteConsultation(consultation);
	}
	@PutMapping("/{id}")
	public Consultation updatDetails(@PathVariable int id, @RequestBody Consultation consultation) {
		//TODO: process PUT request
		Consultation consultation1	=  consultationService.findById(id);
		consultation1.setDoctername(consultation.getDoctername());
		consultation1.setMedications(consultation.getMedications());
		consultation1.setObservations(consultation.getObservations());
		consultation1.setPatientid(consultation.getPatientid());
		return consultationService.saveConsultation(consultation1);
	}
	@GetMapping("patient/{patientid}")
	public List<Consultation> getConsulationDetailsByPatientid(@PathVariable int patientid) {
		return consultationService.finbyid(patientid);
	}
	
}
