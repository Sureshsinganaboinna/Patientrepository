package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="backofficeusers")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	private String email;
	private String password;
	private String mobile;
	private String name;
	private String resetPasswordLink;
	
	private LocalDateTime createdOn = LocalDateTime.now();
	private Boolean isActive = true;
	private Boolean isEmailVerified = false;
	private String ipAddress;
	
	private String accountNumber;
	private Double amount;

}
