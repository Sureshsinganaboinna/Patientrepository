package com.itc.restclient.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "instructors")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long exp;
	private String email;
	
	/*@OneToMany
	@JoinColumn(name = "instructorId")
	private List<Course>courses;    */
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "instructor")  // This should match the property name in Course entity
	    private List<Course> courses;
	
//	 
//	 @OneToMany(mappedBy = "instrcutor")
//	 private List<Course> courses2;
//	 
	 
	 
}
