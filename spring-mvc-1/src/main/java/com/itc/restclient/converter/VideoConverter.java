package com.itc.restclient.converter;

import com.itc.restclient.dto.VideoDto;
import com.itc.restclient.entities.Video;

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
