package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ApiData")
public class ApiResponseData {
	     @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	      public int id;
	      public String ip;
	      public String city;
	      public String region;
	      public String country;
	      public String loc;
	      public String org;
	      public String postal;
	      public String timezone;
	      public String readme;

}
