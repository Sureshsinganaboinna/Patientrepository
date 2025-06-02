package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/MonthlyReport/month/year")
	public void getMonthlyReport(@PathVariable int month, @PathVariable int year)
	{
		orderService.getMonthlyReport(month, year);
		
	}
	
	@GetMapping("/Orders/{userId}")
	public List<Order> getNumberOfOrders(@PathVariable Long userId) {
		
		
		  List<Order> dborderss =  orderService.getOrderDetailsByUserId(userId);
		  
		  
		  return dborderss;
	}
	
	

}
