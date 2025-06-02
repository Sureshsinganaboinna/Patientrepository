package com.itc.restclient.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Employee;
import com.itc.restclient.repository.EmployeeRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	private ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	public Future<Employee> insertEmployeeData(Employee employee)
	{
		   return executorService.submit(() -> employeeRepository.save(employee));
	}
	

}
