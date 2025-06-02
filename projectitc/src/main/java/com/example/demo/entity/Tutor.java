package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tutorss")
public class Tutor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tutorId;
	private String name; 
	private String email;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "subject_fk_id")
//	private Subject subject;
     
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_fkey_id")
	private List<Subject> subject;
	
	
	 
}
