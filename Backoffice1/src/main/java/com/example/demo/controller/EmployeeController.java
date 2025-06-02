package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Employee API's")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@PostMapping("/saveEmployess")
	@Operation(description = "we saving the Employee whenever he comes into signup page and enter his details and click on save button",summary = "savinng the employess")
	@ApiResponses(
   	 value = {
   			 @ApiResponse ( responseCode = "200", description = "Payment has been sent successfully."),
   			 @ApiResponse(responseCode = "400", description = "Insuffiecent balance,  or from account is invalid or To account is invalid.")
   	 }
    )
	public ResponseEntity<String>  saveEmployess(@RequestBody List<Employee> empData)
	{
		
	 employeeRepository.saveAll(empData);
	
		
		return ResponseEntity.ok("Data Saved");
	}
	@GetMapping("returnEmployess/{id}")
	public Employee  saveEmployess(@PathVariable Long id)
	{
		
		return  employeeRepository.getInstructerDataById(id);
	}

}
