package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;



@Entity
@Data
@Table(
		name = "products", 
		schema = "itc-backoffice",
		uniqueConstraints = {
				@UniqueConstraint(
					name = "sku_unique",
					columnNames = "stock_keeping_unit"
	           ),
				@UniqueConstraint(
			     name = "name_unique",
			     columnNames = "name"
			   )
				
		}
  )
public class Product {
	@Id
	private Long id;
	
	@Column(name = "stock_keeping_unit", nullable = false)   //in order to make customize column name we can use @column
	private String sku; 
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	@CreationTimestamp
	private LocalDateTime dateCreate;
	@CreationTimestamp
	private LocalDateTime lastUpdated;

}
