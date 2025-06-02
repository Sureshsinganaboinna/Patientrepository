package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table (name = "contDetail")
public class Contdetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	
	private String firstName;
	private String LastName;
	private String phoneNumber;
	private String Email;
	private String company;

}
