package com.example.demo.converter;

import com.example.demo.dto.VideoDto;
import com.example.demo.entity.Video;

public class VideoConverter {
	
	public static VideoDto convertVedioToVedioDto(Video video)
	{
	
		VideoDto videoDto = new VideoDto();
		videoDto.setId(video.getId());
		videoDto.setDescription(video.getDescription());
		videoDto.setTitle(video.getTitle());
		videoDto.setVideoPath(video.getVideoPath());
		System.out.println(videoDto);
		
		return videoDto;
		
		
		
	}
	
	

}
