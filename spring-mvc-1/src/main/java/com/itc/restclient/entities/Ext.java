package com.itc.restclient.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Exts")
@Data
public class Ext {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String extId;
	private String displayName;
	private String description;
	private String FollowUptext;
	private Boolean deleteFlag = true;
	
	@ManyToOne
	@JoinColumn(name = "Ext_Type")
	private ExtType extTypes;

}
