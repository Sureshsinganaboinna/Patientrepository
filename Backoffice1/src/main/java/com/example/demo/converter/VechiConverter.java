package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.VDtoClass;
import com.example.demo.entity.Vechi;

public class VechiConverter {
	
	public static List<VDtoClass> convertVechicleDbdata(List<Vechi> vechi)
	{
		
		 return vechi.stream()
		            .map(vechiItem -> {
		                VDtoClass vDtoClass = new VDtoClass();
		                vDtoClass.setBrandname(vechiItem.getBrandName());
		                vDtoClass.setModelname(vechiItem.getModelName());
		                vDtoClass.setTrimname(vechiItem.getTrimName());
		                vDtoClass.setVechiclename(vechiItem.getVechicleName());
		                return vDtoClass;
		            }) 
		            .collect(Collectors.toList());
		 
	}
//	instructorDto.setCourses(instructor.getCourses().stream().map(course ->{
//		
//		CourseDTO courseDTO = new CourseDTO();
//		courseDTO.setId(course.getId());
//		courseDTO.setTitle(course.getTitle());
//		courseDTO.setDescription(course.getDescription());
//		return courseDTO;
//		
//	}).collect(Collectors.toList()));
}
