package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "inMany")
public class InMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long exp;
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(
		        name = "inMany_coMany", // The name of the join table
		        joinColumns = @JoinColumn(name = "inMany_id"), // Foreign key for InMany
		        inverseJoinColumns = @JoinColumn(name = "coMany_id") // Foreign key for CoMany
		    )
	private List<CoMany>coMany;
	
}
