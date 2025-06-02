package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.VechiConverter;
import com.example.demo.dto.VDtoClass;
import com.example.demo.entity.Vechi;
import com.example.demo.pojo.VechiclePojo;
import com.example.demo.repository.VechiRepo;
import com.example.demo.repository.VechisRepository;

@Service
public class Practiceservice {
	
	@Autowired
	private VechisRepository vechisRepository;
	@Autowired
	private VechiRepo vechiRepo;
	
	  public Vechi saveVechilesList(VechiclePojo vechiclePojo)
	  {
		  Vechi vechi = new Vechi();
vechi.setBrandName(vechiclePojo.getBrandname());
vechi.setModelName(vechiclePojo.getModelname());
vechi.setTrimName(vechiclePojo.getTrimname());
vechi.setVechicleName(vechiclePojo.getVechiclename());

	Vechi rfdbVechi	=  vechisRepository.save(vechi);
	return rfdbVechi;
		  
	  }
	  
  public List<VDtoClass> vechilcSearchApi(VechiclePojo vechiclePojo) {
	  
	  List<Vechi> vechi = vechiRepo.vechicleDataFromDatabase(vechiclePojo.getBrandname(),vechiclePojo.getModelname(),vechiclePojo.getTrimname(),vechiclePojo.getVechiclename());
	 List<VDtoClass> vDtoClass = VechiConverter.convertVechicleDbdata(vechi);
	  
	  return vDtoClass;
  }
	  
	  
	  
	  
}
