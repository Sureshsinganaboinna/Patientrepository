package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vechicle;
import com.example.demo.pojo.VechiclesSearchApiData;
import com.example.demo.repository.VechicleJdbcRepository;
import com.example.demo.repository.VechicleRepository;

@Service
public class VechicleSearchApiService {
	
	@Autowired
	public VechicleRepository vechicleRepository;
	@Autowired
	public VechicleJdbcRepository vechicleJdbcRepository;
	
	
	public void saveVechicleSearchApiData(VechiclesSearchApiData vechiclesSearchApiData)
	{
	     
		Vechicle vechicle = new Vechicle();
		vechicle.setYear(vechiclesSearchApiData.getYear());
		vechicle.setBrand(vechiclesSearchApiData.getBrand());
		vechicle.setModel(vechiclesSearchApiData.getModel());
		vechicle.setTrim(vechiclesSearchApiData.getTrim());
		
		vechicleRepository.save(vechicle);

		System.out.println(vechiclesSearchApiData.getBrand());
	}
	public List<Vechicle> vechicleSearchApiData(VechiclesSearchApiData vechiclesSearchApiData)
	{
		List<Vechicle>  vechicless= vechicleJdbcRepository.vechicleSearchApi(vechiclesSearchApiData.getYear(),vechiclesSearchApiData.getBrand(),vechiclesSearchApiData.getModel(),vechiclesSearchApiData.getTrim());     
		return vechicless;
	}

	
	
}
