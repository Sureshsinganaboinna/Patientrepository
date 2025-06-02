package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "VechisRecords")
public class Vechi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vechiId;
	private String vechicleName;
	private String brandName;
	private String modelName;
	private String trimName;

}
