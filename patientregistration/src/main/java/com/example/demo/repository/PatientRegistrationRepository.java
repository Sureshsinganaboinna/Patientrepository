package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PatientRegistration;


public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer> {

}
