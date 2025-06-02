package com.itc.restclient.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table( name = "Emplootable" )
public class EmployeeTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	private String eName;
	private String eDepartment;
	

}
