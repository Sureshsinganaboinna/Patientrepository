package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class InstructorDto {

	 private Long id;
	    private String name;
	    private Long exp;
	    private String email;
	    private List<CourseDTO> courses;
}
