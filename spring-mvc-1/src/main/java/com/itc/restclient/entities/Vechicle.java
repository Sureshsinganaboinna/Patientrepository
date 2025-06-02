package com.itc.restclient.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Vechicles")
public class Vechicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vechicleid;
	
	 @Column(name = "year", nullable = false)
	private int year;
	private String brand;
	private String model;
	private String trim;

}
