package com.example.demo.entities;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Patientregistrations", schema = "host")
@Data
public class PatientRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String address;
	private String contactNumber;
	private String details;

}
