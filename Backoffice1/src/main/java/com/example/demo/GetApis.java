package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class GetApis {
	
	
	@GetMapping ("b")  //http://localhost:8080/b?endcoding=UTF8&endcoding1=UTF8&node=1380374031&ref=sv_top_hk_mega_6
	public String getAmazonDetails1(@RequestParam String endcoding, @RequestParam String endcoding1, @RequestParam String node, @RequestParam String ref)
	{
		
		return "Got the Amazon Details"+ endcoding1 + endcoding1 + node + ref;
		
	}
	@GetMapping ("c") //http://localhost:8080/c?name=suresh&Age=25
   public String getMethod(@RequestParam String name, @RequestParam int Age)
   {
	   return "My Name"+  name + "My Age "+  Age;
   }
	@GetMapping ("k")  //http://localhost:8080/k?node=1380374031&ref=sv_top_hk_mega_6  when we are query parameters in the URl level
	public String getAmazonDetails(@RequestParam String node, @RequestParam String ref)
	{
		
		return "Got the Amazon Details"+ node + ref ;
		
	}
	@GetMapping("iTC/{customerid}")  //http://localhost:8080/iTC/98655565
	public int customerGuid(@PathVariable int customerid)
	{
		return customerid;
	}
	@GetMapping("{seotitle}/iTC/{productid}")  //http://localhost:8080/Apple-iphone-15-128GB/iTC/B0CHX7STQQ
	public String productDetailes(@PathVariable String seotitle,@PathVariable String productid)
	{
		return "Product name :- " + seotitle + "    "+ "Product id :- " + productid;
	}
	
	
	
}
