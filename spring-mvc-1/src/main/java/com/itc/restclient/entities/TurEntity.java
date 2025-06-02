package com.itc.restclient.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Tuts")
public class TurEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tutorId;
	private String name; 
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subEntity_fk_id")
	private SubEntity subEntity;
	
}
