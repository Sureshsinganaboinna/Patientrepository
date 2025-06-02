package com.itc.restclient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.Account;
import com.itc.restclient.entities.Productt;
import com.itc.restclient.repository.ProductRepositorry;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductRepositorry productRepositorry;
	
	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> getproducts(@RequestParam(defaultValue = "jonnnn") String name, @RequestParam(defaultValue = "tttt") String catogory)
	{   	
		List<Productt>  pp =	productRepositorry.findBynameAndCatogory(name, catogory);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "success");
		resMap.put("response", pp);
		return ResponseEntity.status(HttpStatus.OK).body(resMap);
	//	System.out.println(name + catogory);
		
		
	}

}
