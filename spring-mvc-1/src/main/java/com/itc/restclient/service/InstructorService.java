package com.itc.restclient.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.converter.InstructorConvertor;
import com.itc.restclient.dto.InstructorDto;
import com.itc.restclient.entities.Instructor;
import com.itc.restclient.repository.InstructorRepository;



@Service
public class InstructorService {
	
	
	@Autowired
	private InstructorRepository instructorRepository;

	public InstructorDto getInstructorData(Long id) {

		Instructor instructor = instructorRepository.getInstructorData(id);
		// VideoDto videoDto = VideoConverter.convertVedioToVedioDto(video);
		// List<VideoDto> videoDto1 =
		// videos.stream().map(VideoConverter::convertVedioToVedioDto).collect(Collectors.toList());
		InstructorDto instructorDto = InstructorConvertor.convertInstructToInstructorDto(instructor);

		return instructorDto;
	}
}
