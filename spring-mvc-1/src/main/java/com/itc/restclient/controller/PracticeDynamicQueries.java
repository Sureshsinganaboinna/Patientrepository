package com.itc.restclient.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.dto.VDtoClass;
import com.itc.restclient.entities.InstaEntity;
import com.itc.restclient.entities.TurEntity;
import com.itc.restclient.entities.Vechi;
import com.itc.restclient.pojo.VechiclePojo;
import com.itc.restclient.repository.InstaEntityRepository;
import com.itc.restclient.repository.SubEntityRepository;
import com.itc.restclient.repository.TutEntityRepository;
import com.itc.restclient.service.Practiceservice;



@RestController
public class PracticeDynamicQueries {
	
	@Autowired
	private Practiceservice practiceservice;
	@Autowired
	private TutEntityRepository tutEntityRepository;
	
	@Autowired
	private SubEntityRepository subEntityRepository;
	@Autowired
	private InstaEntityRepository instaEntityRepository;
	
	@PostMapping("/VechileData")
	public ResponseEntity<Map<String, Object>> saveVechiclesList(@RequestBody VechiclePojo vechiclePojo)
	{
		Vechi bdVechi = practiceservice.saveVechilesList(vechiclePojo);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("DatabaseResponse", bdVechi);
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	@GetMapping("/searchVechicles")
	public List<VDtoClass> searchVechicles(@RequestBody VechiclePojo vechiclePojo)
	{
		 List<VDtoClass> dblist = practiceservice.vechilcSearchApi(vechiclePojo);
		return dblist;
	}
	
	@PostMapping("/OneToOneUnidirectional")
	public void savingOneToOneMappingData(@RequestBody List<TurEntity> turEntities )
	{
		tutEntityRepository.saveAll(turEntities);
	}
	@GetMapping("OneToOneUnidirectional/{id}")
	public TurEntity getDataOneToOneMappingData(@PathVariable Long id )
	{
		
				 TurEntity listfromDb = tutEntityRepository.getTutorDetailAlongWithSubjects(id);
				 return listfromDb;
	}
	@PostMapping("/OneToManyUnidirectional")
	public void savingOneToManyeMappingData(@RequestBody List<InstaEntity> instaEntity )
	{
		instaEntityRepository.saveAll(instaEntity);
	}
	@GetMapping("OneToManyUnidirectional/{id}")
	public List<InstaEntity> getDataManyToOneMappingData(@PathVariable Long id )
	{
		
				 List<InstaEntity> listfromDb = instaEntityRepository.getInstaDbData(id);
				 return listfromDb;
	}
	   @GetMapping("/books/optional-authors")
	    public List<InstaEntity> getAllBooksWithOptionalAuthors() {
	        return instaEntityRepository.findAllCoursesWithOptionalInsta();
	    }

}
