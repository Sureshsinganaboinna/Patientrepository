package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ReportRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ReportRepository reportRepository;
	
	public List<Order> getOrderDetailsByUserId(Long userId)
	{
		
		
	       List<Order> dborders	= orderRepository.getOrderDetailsByUserId(userId);
	       
	      // System.out.println(dborders);
		
		return dborders;
	}
	
	public void getMonthlyReport(int month, int year)
	{
		reportRepository.getMonthlyReport(month, year);
		 
		 
	}
	
	

}
