package com.itc.restclient.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "instssu")
public class InstaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long exp;
	private String email;
	
	
//	@OneToMany (mappedBy = "instaEntity")
//	private List<CourEntity> courEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "insta_fkey_id")
	private List<CourEntity> courEntity;
	
}
