package com.itc.restclient.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "subs")
public class SubEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subjectId;
	private String subjectName;
	private Long experience; 
	
	
    
}
