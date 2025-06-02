package com.itc.restclient.pojo;

import java.sql.Date;
import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Ent {
	
	@NotEmpty(message = "description should not empty")
	@NotNull(message = "description should not be empty")
	private String description;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate  entrydate;
	private Long usid;

}
