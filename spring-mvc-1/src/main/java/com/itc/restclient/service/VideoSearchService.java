package com.itc.restclient.service;

import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.converter.VideoConverter;
import com.itc.restclient.dto.VideoDto;
import com.itc.restclient.entities.Video;
import com.itc.restclient.pojo.VideosSearch;
import com.itc.restclient.repository.VideoRepository;



@Service
public class VideoSearchService {
	
	@Autowired
	private VideoRepository videoRepository;

	
	public  List<VideoDto> videoSearchByusingWord(VideosSearch videosSearch)
	{
		List<Video> videos =   videoRepository.searchWord(videosSearch.getSearchword());
		System.out.println(videos);
		Video video = videos.get(0);
		System.out.println(video);
	 //   VideoDto videoDto = VideoConverter.convertVedioToVedioDto(video);
	   List<VideoDto> videoDto1 =  videos.stream().map(VideoConverter::convertVedioToVedioDto).collect(Collectors.toList());
	   
		return videoDto1;
	}

}
