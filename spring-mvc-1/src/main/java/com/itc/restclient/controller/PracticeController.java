package com.itc.restclient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.Entra;
import com.itc.restclient.entities.Usesss;
import com.itc.restclient.pojo.Ent;
import com.itc.restclient.pojo.Usss;
import com.itc.restclient.repository.EntraaaRepository;
import com.itc.restclient.service.UsessService;

import jakarta.validation.Valid;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;

@RestController
public class PracticeController {
	
	@Autowired
	private UsessService usessService;
	
	@Autowired
	private EntraaaRepository entraaaRepository;
	
	
	
	@PostMapping("/registerPage")
	public Usesss saveUserRegisInfo(@Valid @RequestBody Usss usss)
	{
		Usesss usesss	= usessService.saveUserRegisterInfo(usss);
		return usesss;
	}
	
	@GetMapping("/loguser")
	public ResponseEntity<Map<String, Object>> logUser(@RequestBody Usss usss) throws Exception
	{
	  Optional<Usesss>  usinfo =	usessService.userLogIn(usss);
	  Usesss sess	 = usinfo.get();
		  
		  List<Entra> entra =	entraaaRepository.findByUsid(sess.getId());
		  
		  Map<String, Object> resssMap = new HashMap<String, Object>();
			 resssMap.put("result", "success");
			 resssMap.put("UserentryData", entra);
		  
		  return ResponseEntity.status(HttpStatus.OK).body(resssMap);
	
	  
	}
	@PostMapping("/Entry")
	public void saveUserEn(@RequestBody Ent ent)
	{
		usessService.saveUserEntry(ent);
	}
//	@GetMapping("/{id}")
//	public void getUserEntryDetails(@PathVariable int id)
//	{
//	  Optional<Entra> entra =	entraaaRepository.findById(id);
//	}
	

}
