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
@Table(name = "Employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String empName;
	private int empAge;
	 
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_add_id")
//	private Address address;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_emp_id")
	private List<Address> address;

}
