package com.example.demo.controller;

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

import com.example.demo.dto.VDtoClass;
import com.example.demo.entity.InstaEntity;
import com.example.demo.entity.TurEntity;
import com.example.demo.entity.Vechi;
import com.example.demo.pojo.VechiclePojo;
import com.example.demo.repository.InstaEntityRepository;
import com.example.demo.repository.SubEntityRepository;
import com.example.demo.repository.TutEntityRepository;
import com.example.demo.service.Practiceservice;



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
