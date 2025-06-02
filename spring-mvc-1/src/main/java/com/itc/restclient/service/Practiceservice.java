package com.itc.restclient.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.converter.VechiConverter;
import com.itc.restclient.dto.VDtoClass;
import com.itc.restclient.entities.Vechi;
import com.itc.restclient.pojo.VechiclePojo;
import com.itc.restclient.repository.VechiRepo;
import com.itc.restclient.repository.VechisRepository;

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
