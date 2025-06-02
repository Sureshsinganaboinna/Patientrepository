package com.twg.springcloud.restclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.twg.springcloud.dto.Patient;

@FeignClient("patient-registration-service")//api-gateway-service
//@FeignClient("API-GATEWAY-SERVICE")
public interface PatientRegRestclient {
	
	//This is a rest client for patient registration
	// this is rest api client of patient registration
	//@GetMapping("/patientregistration/Patients/{id}")
	@GetMapping("/Patients/{id}")
	Patient getPatientDetails(@PathVariable  int id) ;
}
