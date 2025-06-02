package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.PatientRegistration;
import com.example.demo.pojo.Patient;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("/Patients")
public class PatientController {
	
	@Autowired
	public PatientService patientService;
	
	@PostMapping("/Save")
	public PatientRegistration savePatient(@RequestBody Patient patient) {
	return	patientService.savePatient(patient);
	}
	
	@PutMapping("/{id}")
	public PatientRegistration updatePatient(@PathVariable("id") int id, @RequestBody Patient patient) {
		
		PatientRegistration patientRegistration	=	patientService.findById(id);
		patientRegistration.setName(patient.getName());
		patientRegistration.setAddress(patient.getAddress());
		patientRegistration.setContactNumber(patient.getContactNumber());
		patientRegistration.setDetails(patient.getDetails());
		
		System.out.println(patient);
		System.out.println(id);
		
		return	patientService.updatePatient(patientRegistration);
		
		}
	@GetMapping("/{id}")
	public PatientRegistration getPatient(@PathVariable("id") int id) {
		return	patientService.findById(id);
		}
	
	@GetMapping("/NoOfPatients")
	public List<PatientRegistration> getPatient() {
		return	patientService.findByAll();
		}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable("id") int id) {
		
		PatientRegistration patientRegistration	=	patientService.findById(id);
		patientService.deletePatient(patientRegistration);
		}
	
}
