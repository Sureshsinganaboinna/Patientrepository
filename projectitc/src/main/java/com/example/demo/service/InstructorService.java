package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.InstructorConvertor;
import com.example.demo.converter.VideoConverter;
import com.example.demo.dto.InstructorDto;
import com.example.demo.dto.VideoDto;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorRepository;

@Service
public class InstructorService {
	
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	public InstructorDto getInstructorData(Long id)
	{
		
		
		Instructor instructor = instructorRepository.getInstructorData(id);
		 //   VideoDto videoDto = VideoConverter.convertVedioToVedioDto(video);
		//   List<VideoDto> videoDto1 =  videos.stream().map(VideoConverter::convertVedioToVedioDto).collect(Collectors.toList());
		InstructorDto instructorDto = InstructorConvertor.convertInstructToInstructorDto(instructor);
		
		return instructorDto;
	}
}
