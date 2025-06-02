package com.itc.restclient.converter;

import java.util.stream.Collectors;

import com.itc.restclient.dto.CourseDTO;
import com.itc.restclient.dto.InstructorDto;
import com.itc.restclient.entities.Instructor;



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
