package com.example.demo.converter;

import java.util.stream.Collectors;


import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.InstructorDto;
import com.example.demo.entity.Instructor;

public class InstructorConvertor {
	public static InstructorDto convertInstructToInstructorDto(Instructor instructor)
	{
		InstructorDto instructorDto = new InstructorDto();
		instructorDto.setId(instructor.getId());
		instructorDto.setName(instructor.getName());
		instructorDto.setExp(instructor.getExp());
		instructorDto.setEmail(instructor.getEmail());
		instructorDto.setCourses(instructor.getCourses().stream().map(course ->{
		
			CourseDTO courseDTO = new CourseDTO();
			courseDTO.setId(course.getId());
			courseDTO.setTitle(course.getTitle());
			courseDTO.setDescription(course.getDescription());
			return courseDTO;
			
		}).collect(Collectors.toList()));
			  
		
		return instructorDto;
		
		
		
	}

}
