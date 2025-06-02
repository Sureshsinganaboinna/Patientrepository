package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "UsersSignups", uniqueConstraints = { @UniqueConstraint(name = "user_unique", columnNames = "userName"
), @UniqueConstraint(name = "email_unique", columnNames = "userEmail"

)

})

public class UserSignupEntityPractice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "userName", nullable = false)
	private String name;
	@Column(name = "userEmail", nullable = false)
	private String email;
	private String password;
	private String mobile;
	private String zipcode;
	private BigDecimal price;
	private Boolean nameActive = true; 
	@CreationTimestamp
	private LocalDateTime signupDate;

}
