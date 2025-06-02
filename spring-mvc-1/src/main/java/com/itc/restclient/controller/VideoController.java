package com.itc.restclient.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.dto.VideoDto;
import com.itc.restclient.pojo.Country;
import com.itc.restclient.pojo.State;
import com.itc.restclient.pojo.VideosSearch;
import com.itc.restclient.service.VideoSearchService;
import com.itc.restclient.utils.ResponseData;


@RestController
public class VideoController {
	@Autowired
	private VideoSearchService videoSearchService;
	
	@PostMapping("/videos/search")
	public ResponseEntity<Map<String, Object>> searchVedios(@RequestBody VideosSearch videosSearch)
	{
		List<VideoDto> videoDto1 = videoSearchService.videoSearchByusingWord(videosSearch);
		Map<String, Object> dbresponseMap = new HashMap<String, Object>();
		dbresponseMap.put(ResponseData.RESULT, ResponseData.SUCCESS);
		dbresponseMap.put("searchedData", videoDto1);
		return ResponseEntity.status(HttpStatus.OK).body(dbresponseMap);
	}
	
	  @GetMapping("/countries")
	    public List<Country> getCountries() {
	        List<State> usaStates = new ArrayList<>();
	        usaStates.add(new State("California"));
	        usaStates.add(new State("Texas"));
	        
	        List<Country> countries = new ArrayList<>();
	        countries.add(new Country("USA", usaStates));
	        countries.add(new Country("Canada", new ArrayList<>()));
	        return countries;
	    }
}
